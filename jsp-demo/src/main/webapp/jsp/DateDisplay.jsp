<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>DateDisplay.jsp</TITLE>
</HEAD>
<BODY>
<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GB2312"%>
<% if (Calendar.getInstance().get(Calendar.AM_PM)==Calendar.AM) {%>
早上好！
<%} else {%>
下午好！
<%}%>
欢迎使用WebSphere!
<hr>

<%out.println("这是一个jsp文件，可以显示日期");%>
<!--以下为声明部分-->
<%!

private int calledCount=0; //纪录点击次数

private String getDate(GregorianCalendar gcalendar){

StringBuffer dateStr=new StringBuffer();
dateStr.append(gcalendar.get(Calendar.DATE));
dateStr.append("/");
dateStr.append(gcalendar.get(Calendar.MONTH)+1);
dateStr.append("/");
dateStr.append(gcalendar.get(Calendar.YEAR));
return(dateStr.toString());
}

private int incrementCounter(){
return(++calledCount);
}

%>

今天日期是：<%=getDate(new GregorianCalendar())%>
这个页面被点击了<%=incrementCounter()%>次
</BODY>
</HTML>
