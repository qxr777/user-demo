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
���Ϻã�
<%} else {%>
����ã�
<%}%>
��ӭʹ��WebSphere!
<hr>

<%out.println("����һ��jsp�ļ���������ʾ����");%>
<!--����Ϊ��������-->
<%!

private int calledCount=0; //��¼�������

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

���������ǣ�<%=getDate(new GregorianCalendar())%>
���ҳ�汻�����<%=incrementCounter()%>��
</BODY>
</HTML>
