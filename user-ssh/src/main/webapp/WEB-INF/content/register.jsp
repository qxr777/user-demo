<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/mytaglib.tld" prefix="mytag" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>My JSP 'register.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

	</head>

	<body>
	<font color=red>${message}</font><br>
	<s:fielderror/>
		<form method="post" action="registerUser" name="register">
			<s:text name="user"/>
			<input type="text" name="name">
			<br>
			<s:text name="pass"/>
			<input type="password" name="password">
			<br>
			<s:text name="confirmpass"/>
			<input type="password" name="password2">
			<br>
			<s:text name="email"/>
			<input type="text" name="email">
			<br>
			<s:text name="organizationName"/>
			<mytag:organizationSelectTag/>
			<br>
			<mytag:rolesCheckTag/>
			<br>			
			<input type="submit" value="<s:text name="submit"/>" name="submit">
			<input type="reset" value="<s:text name="reset"/>"  name="reset"><br>
		</form>
	</body>
</html>
