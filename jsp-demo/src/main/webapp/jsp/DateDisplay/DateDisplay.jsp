<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN">
<%@ page contentType="text/html;charset=GB2312"%>
<HTML>
<HEAD>
<TITLE>
ʹ��javabean��JSP
</TITLE>
<META name="GENERATOR" content="IBM WebSphere Studio">
</HEAD>

<BODY BGCOLOR="#FFFFFF">
<H1>ʹ��Java Bean���Ե�JSP</H1>
<P><B>��������в�����JavaBean,��������Bean������</B>.</P>
<jsp:useBean id="DateDisplay" class="DateDisplay.DateDisplayBean" scope="application" />
<P>�����������:&nbsp;<jsp:getProperty name="DateDisplay" property="dateString" /> <BR>
<BR>
���javabean�����õĴ�����<jsp:getProperty name="DateDisplay" property="counter" /> <BR>
</P>
</BODY>
</HTML>
