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
<font color=red><b> 修改之前:</b></font><p>

 产品:<%=TaxRate.getProduct()%><br>
 税率:<%= TaxRate.getRate()%>
 
<jsp:setProperty name="TaxRate" property="product" value="Hello" /> 
<jsp:setProperty name="TaxRate" property="rate" value="2.9" /> 
 <p>

 <b>
 <font color=red>修改之后:</font></b><p>
 产品:<jsp:getProperty name="TaxRate" property="product"/>
 <br>
 税率:<jsp:getProperty name="TaxRate" property="rate"/>
</center>
</BODY>
</HTML>
