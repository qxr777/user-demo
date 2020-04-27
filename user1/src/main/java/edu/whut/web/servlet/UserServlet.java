package edu.whut.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.whut.web.bean.Organization;
import edu.whut.web.bean.User;
import edu.whut.web.exception.BaseException;
import edu.whut.web.exception.EmailFormatException;
import edu.whut.web.exception.HaveExistException;
import edu.whut.web.exception.PasswordMatchException;
import edu.whut.web.util.MD5;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String confirmPassword;
	private String oldPassword;

    /**
     * Default constructor. 
     */
    public UserServlet() {
        // TODO Auto-generated constructor stub
    }
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String resultMsg = "";
		String forwardURL = "UserServlet?action=showAll";
		String action = request.getParameter("action");
		try{
			if(action.equals("showAll")){
				forwardURL = "main.jsp";
				showAllUser(request);
			}else{
				User user = parseUser(request);
				if(action.equals("update")){
					updateUser(user);
				}else if(action.equals("register")){
					registerUser(user);
				}else if(action.equals("delete")){
					deleteUser(user);
				}else if(action.equals("show")){					
					showUser(user, request);	
					forwardURL = "user.jsp";
				}			
			}
		}catch(BaseException exception){
			forwardURL = "error.jsp";
			forward(forwardURL, exception.getMessage(), request, response);
			return;
		}
		forward(forwardURL, resultMsg, request, response);
	}

	private void forward(String url, String message, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);		
		request.setAttribute("message" , message);
		requestDispatcher.forward(request,response);
	}
	
	private HttpServletRequest showAllUser(HttpServletRequest request) throws BaseException {
		User user = new User();
		List<User> users = user.findAllUsers();
		request.setAttribute("users", users);
		return request;
	}	
	
	private HttpServletRequest showUser(User user, HttpServletRequest request) throws BaseException {
		User userShow = user.findById(user.getId());
		request.setAttribute("user", userShow);
		return request;
	}
	
	private void deleteUser(User user) throws BaseException{
        user.delete(user);
	}
	
	private void registerUser(User user) throws BaseException{
		if(user.findByName(user.getName())!=null){
			throw new HaveExistException(user.getName());
		}

		MD5 md5 = new MD5();
		user.setPassword(md5.getMD5ofStr(user.getPassword()));
		user.insert(user);
	}
	
	private void updateUser(User user) throws BaseException{
		user.update(user);			
	}
	
	private User parseUser(HttpServletRequest request) throws BaseException{
		User user = null;
		int id = 0;
		if(request.getParameter("id")!=null)
			id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		if(email!=null && !isEmail(email))
			throw new EmailFormatException(email);
		int organizationId = 0;
		if(request.getParameter("organizationId")!=null)
			organizationId = Integer.parseInt(request.getParameter("organizationId"));
		
		user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);		
		Organization organization = new Organization();
		organization.setId(organizationId);
		user.setOrganization(organization);
		
		this.confirmPassword = request.getParameter("password2");
		if(this.confirmPassword!=null && !confirmPassword.equals(password))
			throw new PasswordMatchException();
		
		return user;		
	}
	
	private boolean isEmail(String email){
		 String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";  
		 Pattern regex = Pattern.compile(check);  
		 Matcher matcher = regex.matcher(email);  
		 boolean isMatched = matcher.matches();  
		 return isMatched;  
	}

}
