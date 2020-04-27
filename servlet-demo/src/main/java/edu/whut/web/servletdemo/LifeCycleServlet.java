package edu.whut.web.servletdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet(urlPatterns={"/LifeCycleServlet"})
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {		// 初始化操作
		System.out.println("** 1、Servlet初始化 --> init()");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// 处理服务
		System.out.println("** 2、Servlet服务 --> doGet()、doPost()");
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// 处理服务
		this.doGet(req, resp);				// 调用doGet()
	}
	public void destroy() {	 			// Servlet销毁
		System.out.println("** 3、Servlet销毁 --> destroy()");
	}


}
