<%@ page language="java" import="java.util.*,edu.whut.web.*"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String action = request.getParameter("action");
	if (action != null && action.equals("login")) {
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	//验证码模块
		String randomCode=(String)session.getAttribute("randomCode");
		String reqRandom=request.getParameter("random");
		MD5 m = new MD5();
		String md5Password=m.getMD5ofStr(password);
		try {
			DB db = new DB();
			String sql = "select USER_PASSWORD from user where USER_NAME='"
					+ username + "';";
			db.excuteQuery(sql);
			if (db.next()) {
				if (randomCode != null && randomCode.equals(reqRandom) && md5Password.equals(db.getString("USER_PASSWORD"))) {
					response.sendRedirect("main.jsp");
				} else {
					response.sendRedirect("login.jsp");
				}
			} else {
				response.sendRedirect("login.jsp");
			}
			db.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
%>

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
		<div>
			<form method="post" action="login.jsp" name="login">
				<input type="hidden" name="action" value="login">
				<table>
					<tr>
						<td>
							用户名：
						</td>
						<td>
							<input type="text" name="username">
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
							<img src="imgcode.jsp">
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="登录" name="submit">
						</td>
						<td>
							<input type="reset" value="重置" name="reset">
						</td>
					</tr>
				</table>
			</form>
		</div>

	</body>
</html>
