<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=GB2312"%>
<HTML>
<HEAD>
<META name="GENERATOR" content="IBM WebSphere Studio">
</HEAD>
<BODY bgcolor=pink>
<%@ page language="java" %>
<jsp:useBean id="TaxRate" scope="application" class="TaxRate.TaxRateBean"/>
<center>
<font color=red><b> �޸�֮ǰ:</b></font><p>

 ��Ʒ:<%=TaxRate.getProduct()%><br>
 ˰��:<%= TaxRate.getRate()%>
 
<jsp:setProperty name="TaxRate" property="product" value="Hello" /> 
<jsp:setProperty name="TaxRate" property="rate" value="2.9" /> 
 <p>

 <b>
 <font color=red>�޸�֮��:</font></b><p>
 ��Ʒ:<jsp:getProperty name="TaxRate" property="product"/>
 <br>
 ˰��:<jsp:getProperty name="TaxRate" property="rate"/>
</center>
</BODY>
</HTML>
