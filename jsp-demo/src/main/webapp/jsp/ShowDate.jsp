<%--字符集设为"gb2312",使动态页面支持中文--%>
<%@ page contentType="text/html; charset=GB2312"%>
<%//引入Java日期类Date%>
<%@ page import="java.util.Date" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>ShowDate.jsp</TITLE>
</HEAD>
<BODY>
<h1>JSP 日期</h1>
<h2>
<% 
//设置信息头强迫客户端每5秒刷新页面，
response.setHeader("Refresh", "5"); %>
现在的时间是
 <%= new Date() %>
</h2>
</BODY>
</HTML>
