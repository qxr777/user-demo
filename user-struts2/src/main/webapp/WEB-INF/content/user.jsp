<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/mytaglib.tld" prefix="mytag" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>My JSP 'user.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>	
<jsp:useBean id="editUser" class="edu.whut.web.bean.User" scope="session"/>	
<s:fielderror/>
		<form method="post" action="updateUser" name="update">
			<input type="hidden" name="id" value=<jsp:getProperty name="editUser" property="id"/>>
			用户名：
			<input type="text" name="name" value=<jsp:getProperty name="editUser" property="name"/>>
			<br>
			电子邮箱：
			<input type="text" name="email" value=<jsp:getProperty name="editUser" property="email"/>>
			<br>
			所属组织：
			<mytag:organizationSelectTag selectedId="<%=editUser.getOrganization().getId()%>"/>
			<br>
			<input type="submit" value="提交" name="submit">
			<input type="reset" value="重置"  name="reset"><br>
		</form>
	</body>
</html>
