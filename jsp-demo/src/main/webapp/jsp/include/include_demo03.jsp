<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>www.mldnjava.cn��MLDN�߶�Java��ѵ</title></head>
<body>
	<h1>��̬��������</h1>
	<%
		String username = "LiXingHua" ;
	%>
	<jsp:include page="receive_param.jsp">
		<jsp:param name="name" value="<%=username%>"/>
		<jsp:param name="info" value="www.mldnjava.cn"/>
	</jsp:include>
</body>
</html>