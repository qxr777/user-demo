package edu.whut.web.servletdemo;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
@WebServlet(urlPatterns={"/InitParamServlet"}
	, initParams={
		@WebInitParam(name="ref", value="www.whut.edu.cn")} )
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String initParam = null ;		//

	public void init(ServletConfig config) throws ServletException{
		this.initParam = config.getInitParameter("ref") ;
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
		System.out.println("接收初始化参数" + this.initParam);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
		this.doGet(req, resp);				// 调用doGet()
	}


}
