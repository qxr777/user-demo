<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title><s:text name="rolePage"/></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
<jsp:useBean id="role" class="edu.whut.web.domain.Role" scope="request"/>	
	<form method="post" action="updateRole" name="formRole">
		<input id="role_id" type="hidden" name="id" value=<jsp:getProperty name="role" property="id"/>>
		<s:text name="roleName"/> <input type="text" name="name" value=<jsp:getProperty name="role" property="name"/>> <br> 
		<s:text name="roleDescription"/><input type="text" name="description" value=<jsp:getProperty name="role" property="description"/>> <br> 
		<input type="submit" value="<s:text name="submit"/>" name="submit" onclick="submitpro();"> 
		<input type="reset" value="<s:text name="reset"/>" name="reset"> <br>
	</form>
<script type="text/javascript">
function submitpro()
{
	//获取页面的第一个表单
	targetForm = document.forms[0];
	organizationInput = document.getElementById("role_id")
	if(organizationInput.value==0)	//动态修改表单的action属性
		targetForm.action = "addRole";

}
</script>
</body>
</html>
