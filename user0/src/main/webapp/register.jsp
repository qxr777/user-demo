<%@ page language="java" import="java.util.*,java.sql.*,edu.whut.web.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String action = request.getParameter("action");
	if (action != null && action.equals("register")) {
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		//这里应该判断2个密码是否一致！
		//开始MD5加密
		MD5 m = new MD5();
		String password=m.getMD5ofStr(password1);
		String organizationId = request.getParameter("organizationId");
		String email = request.getParameter("email");
		String s = "insert into user(USER_NAME,USER_PASSWORD,USER_EMAIL,USER_ORGANIZATION_ID) values('"
				+ username
				+ "','"
				+ password
				+ "','"
				+ email
				+ "',"
				+organizationId
				+ ")";
		try {
			DB db = new DB();
			db.excuteUpdata(s);
			db.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//session.setAttribute("admin", "true");
		response.sendRedirect("login.jsp");
		//}
	}
	String sql = "select * from organization";
	ResultSet rs = null;
	try{
		DB db = new DB();
		rs = db.excuteQuery(sql);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>My JSP 'register.jsp' starting page</title>

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
		<form method="post" action="register.jsp" name="register">
			<input type="hidden" name="action" value="register">
			用户名：
			<input type="text" name="username">
			<br>
			用户密码：
			<input type="password" name="password1">
			<br>
			确认密码：
			<input type="password" name="password2">
			<br>
			电子邮箱：
			<input type="text" name="email">
			<br>
			所属组织：
			<select name="organizationId">
<%
      while(rs.next()){
    	  String organizationId = rs.getString("ORGANIZATION_ID");
    	  String organizationName = rs.getString("ORGANIZATION_NAME");
%>
              <option value=<%=organizationId %>><%=organizationName %></option>
<%
      }
%>						    
			</select>
			<br>
			<input type="submit" value="注册" name="submit">
			<input type="reset" value="重置"  name="reset"><br>
		</form>
	</body>
</html>
