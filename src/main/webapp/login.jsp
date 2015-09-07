<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

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
		<div class="head" style="height: 50px;width: auto;">
  			7872：张艺亨
  		</div>
		<div class="container">
			<s:form action="login.do" method="post">
				<table align="center" style="margin-top: 200px" border="1px">
					<tr><td><p>电影租赁管理系统</p></td></tr>
					<tr><td><s:textfield name="username" label="用户名"></s:textfield></td></tr>
					<tr><td><s:password name="password" label="密码"></s:password><tr><td>
					<tr><td><s:submit label="登录"></s:submit></td></tr>
				</table>
			</s:form>
		</div>
	</div>
</body>
</html>
