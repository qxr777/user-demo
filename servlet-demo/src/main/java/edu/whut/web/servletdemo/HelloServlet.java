package edu.whut.web.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public HelloServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 	// 覆写doGet()方法
		PrintWriter out = resp.getWriter(); 	// 准备输出
		out.println("<html>"); 			// 输出html元素
		out.println("<head><title>JAVA</title></head>");// 输出html元素
		out.println("<body>");			// 输出html元素
		out.println("<h1>HELLO WORLD</h1>");	// 输出html元素
		out.println("</body>");			// 输出html元素
		out.println("</html>");			// 输出html元素
		out.close() ;				// 关闭输出
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
