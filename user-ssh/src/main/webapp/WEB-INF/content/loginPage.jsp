<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title><s:text name="loginPage"/></title>

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
	<!-- <font color="red">${message}</font> -->
	<font color="red"><s:property value="exception.message"/></font>
	<s:fielderror/>
		<div>
			<form method="post" action="login" name="login">
				<table>
					<tr>
						<td>
							<s:text name="user"></s:text>
						</td>
						<td>
							<input type="text" name="name">
						</td>
					</tr>
					<tr>
						<td>
							<s:text name="pass"></s:text>
						</td>
						<td>
							<input type="password" name="password">
						</td>
					</tr>
					<tr>
						<td>
							<s:text name="verifyCode"/>
						</td>
						<td>
							<input type="text" name="random" maxlength="4" size="4">
							<img src="imgcode">
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="<s:text name="login"/>" name="submit">
						</td>
						<td>
							<input type="reset" value="<s:text name="reset"/>" name="reset">
						</td>
						<td>
							<a href="register"><s:text name="registeLink"/></a>
						</td>						
					</tr>
				</table>
			</form>
		</div>

	</body>
</html>
