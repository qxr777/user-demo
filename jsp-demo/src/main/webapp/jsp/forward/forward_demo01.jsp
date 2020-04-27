<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String username = "LiXingHua" ;		// 定义一个变量
%>
<jsp:forward page="forward_demo02.jsp">
		<jsp:param name="name" value="<%=username%>"/>
		<jsp:param name="info" value="www.mldnjava.cn"/>
</jsp:forward>


</body>
</html>