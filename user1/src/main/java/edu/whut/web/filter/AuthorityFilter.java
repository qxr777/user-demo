package edu.whut.web.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName="authority"
	, urlPatterns={"/*"}
	, initParams={
		@WebInitParam(name="loginPage", value="/login.jsp"),
		@WebInitParam(name="allowURL", value="/LoginServlet;/login.jsp;/imgcode;/register.jsp")})
public class AuthorityFilter implements Filter 
{
	//FilterConfig可用于访问Filter的配置信息
	private FilterConfig config;
	private Set<String> allowURLSet;
	String loginPage;
	//实现初始化方法
	public void init(FilterConfig config)
	{
		this.config = config; 
		//获取该Filter的配置参数
		loginPage = config.getInitParameter("loginPage");
		String allowURL = config.getInitParameter("allowURL");
		String[] allowURLArray = allowURL.split(";");
		allowURLSet = new HashSet<String>(Arrays.asList(allowURLArray));  		
	}

	//实现销毁方法
	public void destroy()
	{
		this.config = null; 
	}
	//执行过滤的核心方法
	public void doFilter(ServletRequest request,
		ServletResponse response, FilterChain chain)
		throws IOException,ServletException
	{

		HttpServletRequest requ = (HttpServletRequest)request;
		HttpSession session = requ.getSession(true);
		//获取客户请求的页面
		String requestPath = requ.getServletPath();
		//如果session范围的user为null，即表明没有登录
		//且用户请求的既不是登录页面，也不是处理登录的页面
		if( session.getAttribute("user") == null
			&& !allowURLSet.contains(requestPath))
		{
			//forward到登录页面
			request.setAttribute("message" , "您还没有登录");
			request.getRequestDispatcher(loginPage)
				.forward(request, response);
		}
		//"放行"请求
		else
		{
			chain.doFilter(request, response);
		}
	} 
}
