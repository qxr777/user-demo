package edu.whut.web.servletdemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClientRedirect
 */
@WebServlet("/ClientRedirect")
public class ClientRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// 处理服务
		req.getSession().setAttribute("name", "WHUT") ;	// 设置session属性
		req.setAttribute("info", "WEB COURSE") ;	// 设置request属性
		resp.sendRedirect("RedirectTarget") ;	// 页面跳转
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// 处理服务
		this.doGet(req, resp);				// 调用doGet()
	}

}
