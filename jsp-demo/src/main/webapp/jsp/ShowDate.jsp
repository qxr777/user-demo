<%--�ַ�����Ϊ"gb2312",ʹ��̬ҳ��֧������--%>
<%@ page contentType="text/html; charset=GB2312"%>
<%//����Java������Date%>
<%@ page import="java.util.Date" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>ShowDate.jsp</TITLE>
</HEAD>
<BODY>
<h1>JSP ����</h1>
<h2>
<% 
//������Ϣͷǿ�ȿͻ���ÿ5��ˢ��ҳ�棬
response.setHeader("Refresh", "5"); %>
���ڵ�ʱ����
 <%= new Date() %>
</h2>
</BODY>
</HTML>
