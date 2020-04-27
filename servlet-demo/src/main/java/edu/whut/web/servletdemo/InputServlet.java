package edu.whut.web.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InputServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { 		// 处理get请求
		String info = req.getParameter("info") ;		// 接收请求参数
		PrintWriter out = resp.getWriter(); 			// 准备输出
		out.println("<html>"); 					// 输出html元素		out.println("<head><title>MLDNJAVA</title></head>"); 	// 输出html元素
		out.println("<body>");				// 输出html元素
		out.println("<h1>" + info + "</h1>"); 			// 输出html元素
		out.println("</body>");				// 输出html元素
		out.println("</html>");				// 输出html元素
		out.close() ;					// 关闭输出
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		// 处理post请求
		this.doGet(req, resp) ;				// 同一种方法体处理
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		String info = req.getParameter("info") ;		// 接收请求参数
//		PrintWriter out = resp.getWriter(); 			// 准备输出
//		out.println("<html>"); 				// 输出html元素		out.println("<head><title>MLDNJAVA</title></head>"); 	// 输出html元素
//		out.println("<body>");				// 输出html元素
//		out.println("<h1>" + info + "</h1>"); 			// 输出html元素
//		out.println("</body>");				// 输出html元素
//		out.println("</html>");				// 输出html元素
//		out.close() ;					// 关闭输出
//	}


}
