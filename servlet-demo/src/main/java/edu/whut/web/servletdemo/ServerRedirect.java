package edu.whut.web.servletdemo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServerRedirect
 */
@WebServlet("/ServerRedirect")
public class ServerRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// 处理服务
		req.getSession().setAttribute("name", "WHUT");	// 设置session属性
		req.setAttribute("info", "WEB COURSE") ;		// 设置request属性
		// 实例化RequestDispatcher对象，同时指定跳转路径
		RequestDispatcher rd = req.getRequestDispatcher("RedirectTarget");
		rd.forward(req, resp) ;				// 服务器跳转
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// 处理服务
		this.doGet(req, resp);				// 调用doGet()
	}


}
