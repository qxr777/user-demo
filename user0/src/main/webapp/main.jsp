<%@ page language="java" import="java.util.*,java.sql.*,edu.whut.web.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sql = "select * from user";
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
    
    <title>My JSP 'index.jsp' starting page</title>
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
    后台管理<br>
    <a href="./addOrganization.jsp">添加组织</a><br>
    <a href="./register.jsp">注册用户</a><br>
  <table border="1">
  <tr>
     <th>ID</th>
     <th>用户名</th>
     <th>email</th>
     <th>组织</th>
     <th>操作</th>
  </tr>
<%
    while(rs.next()){
%>  
  <tr>
     <td><%=rs.getString("USER_ID") %></td>
     <td><%=rs.getString("USER_NAME") %></td>
     <td><%=rs.getString("USER_EMAIL") %></td>
     <td><%=rs.getString("USER_ORGANIZATION_ID") %></td>
     <td>
     <a href="user.jsp?action=delete&userId=<%=rs.getString("USER_ID")%>">删除</a>
     <a href="user.jsp?userId=<%=rs.getString("USER_ID")%>">编辑</a>
     </td>
  </tr>
<%
    }
%>  
  </table>      
  </body>
</html>
