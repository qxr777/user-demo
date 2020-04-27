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
	//FilterConfig可用于访问Filter的配置信息
	private FilterConfig config;
	//实现初始化方法
	public void init(FilterConfig config)
	{
		this.config = config; 
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
		//获取该Filter的配置参数
		String encoding = config.getInitParameter("encoding");

		//设置request编码用的字符集
		request.setCharacterEncoding(encoding);			//①
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
