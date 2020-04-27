<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN">
<%@ page contentType="text/html;charset=GB2312"%>
<HTML>
<HEAD>
<TITLE>
使用javabean的JSP
</TITLE>
<META name="GENERATOR" content="IBM WebSphere Studio">
</HEAD>

<BODY BGCOLOR="#FFFFFF">
<H1>使用Java Bean属性的JSP</H1>
<P><B>这个例子中插入了JavaBean,并访问了Bean的属性</B>.</P>
<jsp:useBean id="DateDisplay" class="DateDisplay.DateDisplayBean" scope="application" />
<P>今天的日期是:&nbsp;<jsp:getProperty name="DateDisplay" property="dateString" /> <BR>
<BR>
这个javabean被调用的次数：<jsp:getProperty name="DateDisplay" property="counter" /> <BR>
</P>
</BODY>
</HTML>
