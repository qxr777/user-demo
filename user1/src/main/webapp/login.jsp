<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>My JSP 'login.jsp' starting page</title>

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
	${message}
		<div>
			<form method="post" action="LoginServlet" name="login">
				<table>
					<tr>
						<td>
							用户名：
						</td>
						<td>
							<input type="text" name="name">
						</td>
					</tr>
					<tr>
						<td>
							密码：
						</td>
						<td>
							<input type="password" name="password">
						</td>
					</tr>
					<tr>
						<td>
							验证码：
						</td>
						<td>
							<input type="text" name="random" maxlength="4">
							<img src="imgcode">
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="登录" name="submit">
						</td>
						<td>
							<input type="reset" value="重置" name="reset">
						</td>
						<td>
							<a href="register.jsp">注册用户</a>
						</td>						
					</tr>
				</table>
			</form>
		</div>

	</body>
</html>
