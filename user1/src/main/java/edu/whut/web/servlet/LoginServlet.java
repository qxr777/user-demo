package edu.whut.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.whut.web.bean.User;
import edu.whut.web.exception.BaseException;
import edu.whut.web.exception.NoUserException;
import edu.whut.web.exception.PasswordErrorException;
import edu.whut.web.exception.VerifyCodeErrorException;
import edu.whut.web.util.MD5;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String message = null;
		String forwardURL = "UserServlet?action=showAll";
		String random = request.getParameter("random");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String randomInSession = (String) request.getSession().getAttribute(
				"randomCode");

		MD5 md5 = new MD5();
		try {
			if (!random.equals(randomInSession)) {
				throw new VerifyCodeErrorException();
			}
			User userInDB = new User();
			userInDB = userInDB.findByName(name);
			if (userInDB == null)
				throw new NoUserException();
			if (userInDB != null
					&& !userInDB.getPassword()
							.equals(md5.getMD5ofStr(password)))
				throw new PasswordErrorException();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardURL = "login.jsp";
			forward(forwardURL, e.getMessage(), request, response);
			return;
		}
		request.getSession(true).setAttribute("user", name);
		forward(forwardURL, message, request, response);
	}

	private void forward(String url, String message, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);		
		request.setAttribute("message" , message);
		requestDispatcher.forward(request,response);
	}

}
