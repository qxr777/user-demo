package edu.whut.web.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName="charset"
	, urlPatterns={"/*"}
	, initParams={
		@WebInitParam(name="encoding", value="utf-8")})
public class CharsetFilter implements Filter 
{
	//FilterConfig�����ڷ���Filter��������Ϣ
	private FilterConfig config;
	//ʵ�ֳ�ʼ������
	public void init(FilterConfig config)
	{
		this.config = config; 
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
		//��ȡ��Filter�����ò���
		String encoding = config.getInitParameter("encoding");

		//����request�����õ��ַ���
		request.setCharacterEncoding(encoding);			//��
//		Map<String,String[]> paramMap = request.getParameterMap();
//		Enumeration<String> paramNames = request.getParameterNames();
//		while(paramNames.hasMoreElements()){
//			String paramName = paramNames.nextElement();
//			String paramValue = new String(request.getParameter(paramName).trim().getBytes("ISO-8859-1"));
//			String[] paramValueArray= {paramValue};
//			paramMap.put(paramName, paramValueArray);
//		}
		chain.doFilter(request, response);
	} 
}
