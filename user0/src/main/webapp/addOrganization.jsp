<%@ page language="java" import="java.util.*,edu.whut.web.*"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String action = request.getParameter("action");
	if (action != null && action.equals("addOrganization")) {
		String organizationName = request.getParameter("organizationName");
		String organizationDescription = request.getParameter("organizationDescription");

			String s = "insert into organization(ORGANIZATION_NAME,ORGANIZATION_DESCRIPTION) values('"
					+ organizationName + "','" + organizationDescription + "')";
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
	<form method="post" action="addOrganization.jsp" name="register">
		<input type="hidden" name="action" value="addOrganization"> 
		组织名称： <input type="text" name="organizationName"> <br> 
		组织描述： <input type="text" name="organizationDescription"> <br> 
		<input type="submit" value="提交" name="submit"> 
		<input type="reset" value="重置" name="reset"> <br>
	</form>
</body>
</html>
