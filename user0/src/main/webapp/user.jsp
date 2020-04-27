<%@ page language="java" import="java.util.*,java.sql.*,edu.whut.web.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
    ResultSet rs = null;
    String userId = request.getParameter("userId");
	String s = "select * from user where USER_ID=" + userId;
	try{
		DB db = new DB();
		rs = db.excuteQuery(s);
		rs.next();
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}    
	String action = request.getParameter("action");
	
	if (action != null && action.equals("delete")) {		
		s = "delete from user where USER_ID=" + userId;
		try {
			DB db = new DB();
			db.excuteUpdata(s);
			db.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//session.setAttribute("admin", "true");
		response.sendRedirect("main.jsp");
		//}
	}else if(action!=null&&action.equals("update")){
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String organizationId = request.getParameter("organizationId");
		s = "update user set USER_NAME='"+userName+"',USER_EMAIL='"+email+"',USER_ORGANIZATION_ID="+organizationId+" where USER_ID="+userId;
		try {
			DB db = new DB();
			db.excuteUpdata(s);
			//db.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//session.setAttribute("admin", "true");
		response.sendRedirect("main.jsp");		
    }
	String sql = "select * from organization";
	ResultSet resultSet = null;
	try{
		DB db = new DB();
		resultSet = db.excuteQuery(sql);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
%>

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
		<form method="post" action="user.jsp" name="register">
			<input type="hidden" name="action" value="update">
			<input type="hidden" name="userId" value="<%=rs.getString("USER_ID")%>">
			用户名：
			<input type="text" name="username" value="<%=rs.getString("USER_NAME")%>">
			<br>
			电子邮箱：
			<input type="text" name="email" value="<%=rs.getString("USER_EMAIL")%>">
			<br>
			所属组织：
			<select name="organizationId">
<%
      while(resultSet.next()){
    	  String organizationId = resultSet.getString("ORGANIZATION_ID");
    	  String organizationName = resultSet.getString("ORGANIZATION_NAME");
%>
              <option value=<%=organizationId %> <%=organizationId.equals(rs.getString("USER_ORGANIZATION_ID"))?"SELECTED":"" %>><%=organizationName %></option>
<%
      }
%>						    
			</select>
			<br>
			<input type="submit" value="提交" name="submit">
			<input type="reset" value="重置"  name="reset"><br>
		</form>
	</body>
</html>
