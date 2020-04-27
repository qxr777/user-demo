<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/mytaglib.tld" prefix="mytag" %>
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
		<form method="post" action="UserServlet" name="register">
			<input type="hidden" name="action" value="register">
			用户名：
			<input type="text" name="name">
			<br>
			用户密码：
			<input type="password" name="password">
			<br>
			确认密码：
			<input type="password" name="password2">
			<br>
			电子邮箱：
			<input type="text" name="email">
			<br>
			所属组织：
			<mytag:organizationSelectTag/>
			<br>
			<input type="submit" value="注册" name="submit">
			<input type="reset" value="重置"  name="reset"><br>
		</form>
	</body>
</html>
