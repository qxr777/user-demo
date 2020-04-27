package edu.whut.web.interceptor;

import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.*;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
//权限检查拦截器继承AbstractInterceptor类
public class AuthorityInterceptor
	extends AbstractInterceptor
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9077230585541595759L;

	//拦截Action处理的拦截方法
	public String intercept(ActionInvocation invocation)
		throws Exception
	{
		//取得请求相关的ActionContext实例
		ActionContext ctx = invocation.getInvocationContext();
		Map<String, Object> session = ctx.getSession();
		//取出名为user的Session属性
		String user = (String)session.get("user");
		//如果没有登录，或者登录所用的用户名不是scott，都返回重新登录
		if (user != null )
		{
			return invocation.invoke();
		}
		//没有登录，将服务器提示设置成一个HttpServletRequest属性
		ctx.put("message" ,
			"您还没有登录，请输入正确的用户名和密码登录系统");
		//直接返回login的逻辑视图
		return Action.LOGIN;
	}
}
