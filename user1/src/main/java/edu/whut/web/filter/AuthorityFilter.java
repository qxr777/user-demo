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
	//FilterConfig�����ڷ���Filter��������Ϣ
	private FilterConfig config;
	private Set<String> allowURLSet;
	String loginPage;
	//ʵ�ֳ�ʼ������
	public void init(FilterConfig config)
	{
		this.config = config; 
		//��ȡ��Filter�����ò���
		loginPage = config.getInitParameter("loginPage");
		String allowURL = config.getInitParameter("allowURL");
		String[] allowURLArray = allowURL.split(";");
		allowURLSet = new HashSet<String>(Arrays.asList(allowURLArray));  		
	}

	//ʵ�����ٷ���
	public void destroy()
	{
		this.config = null; 
	}
	//ִ�й��˵ĺ��ķ���
	public void doFilter(ServletRequest request,
		ServletResponse response, FilterChain chain)
		throws IOException,ServletException
	{

		HttpServletRequest requ = (HttpServletRequest)request;
		HttpSession session = requ.getSession(true);
		//��ȡ�ͻ������ҳ��
		String requestPath = requ.getServletPath();
		//���session��Χ��userΪnull��������û�е�¼
		//���û�����ļȲ��ǵ�¼ҳ�棬Ҳ���Ǵ����¼��ҳ��
		if( session.getAttribute("user") == null
			&& !allowURLSet.contains(requestPath))
		{
			//forward����¼ҳ��
			request.setAttribute("message" , "����û�е�¼");
			request.getRequestDispatcher(loginPage)
				.forward(request, response);
		}
		//"����"����
		else
		{
			chain.doFilter(request, response);
		}
	} 
}
