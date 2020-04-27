<%@ page language="java" import="java.util.*,edu.whut.web.domain.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    ${message}<br>  
    <a href="role">添加角色</a><br>
  <table border="1">
  <tr>
     <th>ID</th>
     <th>角色名</th>
     <th>描述</th>
     <th>成员</th>
     <th>操作</th>
  </tr>
<c:forEach items="${roles}" var="role">  
  <tr>
     <td>${role.id}</td>
     <td>${role.name}</td>
     <td>${role.description}</td>
     <td>
     <c:forEach items="${role.users}" var="user">
     ${user.name}
     </c:forEach>
     </td>     
     <td>
     <a href="deleteRole?id=${role.id}">删除</a>
     <a href="showRole?id=${role.id}">编辑</a>
     </td>
  </tr>
</c:forEach> 
  </table>  
        
    <a href="organization">添加组织</a><br>
  <table border="1">
  <tr>
     <th>ID</th>
     <th>组织名</th>
     <th>描述</th>
     <th>成员</th>
     <th>操作</th>
  </tr>
<c:forEach items="${organizations}" var="org">  
  <tr>
     <td>${org.id}</td>
     <td>${org.name}</td>
     <td>${org.description}</td>
     <td>
     <c:forEach items="${org.users}" var="user">
     ${user.name}
     </c:forEach>
     </td>     
     <td>
     <a href="deleteOrg?id=${org.id}">删除</a>
     <a href="showOrg?id=${org.id}">编辑</a>
     </td>
  </tr>
</c:forEach> 
  </table>      
    
    <a href="register">注册用户</a><br>

  <table border="1">
  <tr>
     <th>ID</th>
     <th>用户名</th>
     <th>email</th>
     <th>组织</th>
     <th>role</th>
     <th>操作</th>
  </tr>
<c:forEach items="${users}" var="user">  
  <tr>
     <td>${user.id}</td>
     <td>${user.name}</td>
     <td>${user.email}</td>
     <td>${user.organization.name}</td>
     <td>
     <c:forEach items="${user.roles}" var="role">
     ${role.name}
     </c:forEach>
     </td>
     <td>
     <a href="deleteUser?id=${user.id}">删除</a>
     <a href="showUser?id=${user.id}">编辑</a>
     </td>
  </tr>
</c:forEach> 
  </table>      
  </body>
</html>
