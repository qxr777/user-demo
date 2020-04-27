package edu.whut.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.whut.web.bean.Organization;

/**
 * Servlet implementation class OrganizationServlet
 */
@WebServlet("/OrganizationServlet")
public class OrganizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrganizationServlet() {
        super();
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
//		String resultMsg = "";
//		String forwardURL = "UserServlet?action=showAll";
//		String action = request.getParameter("action");
//		Organization organization = parseOrganization(request);
//		if(action.equals("addOrganization")){
//			resultMsg = addOrganization(organization);
//		}
//		forward(forwardURL, resultMsg, request, response);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String resultMsg = "";
		String forwardURL = "UserServlet?action=showAll";
		String action = request.getParameter("action");
		Organization organization = parseOrganization(request);
		if(action.equals("addOrganization")){
			resultMsg = addOrganization(organization);
		}
		forward(forwardURL, resultMsg, request, response);
	}

	private void forward(String url, String message, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);		
		request.setAttribute("message" , message);
		requestDispatcher.forward(request,response);
	}	
	
	private String addOrganization(Organization organization){
		String message = null;
		try{
		if(organization.insert(organization)!=null)
			message = "组织" + organization.getName() + "添加成功！";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "组织"+organization.getName()+"添加失败！";
		}
		return message;
	}
	
	private Organization parseOrganization(HttpServletRequest request){
		Organization organization = null;
		//int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		if(name != null){
			organization = new Organization();
			organization.setName(name);
			organization.setDescription(description);
		}
		return organization;
	}
}
