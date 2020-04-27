<%@ page language="java" pageEncoding="UTF-8"%>
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
	<form method="post" action="OrganizationServlet" name="register">
		<input type="hidden" name="action" value="addOrganization"> 
		组织名称： <input type="text" name="name"> <br> 
		组织描述： <input type="text" name="description"> <br> 
		<input type="submit" value="提交" name="submit"> 
		<input type="reset" value="重置" name="reset"> <br>
	</form>
</body>
</html>
