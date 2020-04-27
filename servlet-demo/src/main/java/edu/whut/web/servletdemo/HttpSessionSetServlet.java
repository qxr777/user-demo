package edu.whut.web.servletdemo;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HttpSessionSetServlet
 */
@WebServlet("/HttpSessionSetServlet")
public class HttpSessionSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// 处理服务
		HttpSession ses = req.getSession() ;		// 取得session对象
		System.out.println("SESSION ID --> " + ses.getId());// 取得session id
		ses.setAttribute("username", "administrator") ;		// 设置属性
		System.out.println("username属性内容：" + ses.getAttribute("username"));
		PrintWriter out = resp.getWriter(); 	// 准备输出
		out.println("SESSION ID --> " + ses.getId());
		out.println("username --> " + ses.getAttribute("username"));
		out.close();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// 处理服务
		this.doGet(req, resp);				// 调用doGet()
	}


}
