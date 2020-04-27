package edu.whut.web.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextGetServlet
 */
@WebServlet("/ServletContextGetServlet")
public class ServletContextGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// 处理服务
		ServletContext app = super.getServletContext() ;	// 取得application
		PrintWriter out = resp.getWriter(); 	// 准备输出
		out.println("appName --> " + app.getAttribute("appName"));
//		out.println("appPath --> " + app.getRealPath("/"));
		out.close();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// 处理服务
		this.doGet(req, resp);				// 调用doGet()
	}

}
