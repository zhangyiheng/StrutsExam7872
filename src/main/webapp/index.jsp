<%@page import="com.hand.bean.Customer"%>
<%@page import="java.sql.ResultSet"%>
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
			<p>7872:张艺亨</p>
			<div class="user"></div>
		</div>
		<div class="container" >
			<div class="leftdiv" border="1px">
				<ul class="nav nav-pills nav-stacked" >
					<li><a href="#">Customer管理</a></li>
					<li><a href="#">Film設置</a></li>
				</ul>
			</div>
			<div class="rightdiv">
				<table border="1px">
					<tr><td colspan="7"  align="center">客户管理<button type="button" href="insert.jsp"><a href="insert.jsp">添加</a></button></td></tr>
					<tr><td>操作</td><td>First Name</td><td>Last Name</td><td>Address</td><td>Email</td><td>CustomerId</td><td>LastUpdate</td></tr>
					<%
						List rs = (List)session.getAttribute("customers");
						//List<Customer> customers = new ArrayList<Customer>();
						
						for(Iterator iterator = rs.iterator();iterator.hasNext();){
							Customer customer = (Customer)iterator.next();
							out.print("<tr>");
		  		 			out.print("<td>");
		  		 			out.print("<a href='#' name = 'bianji'>编辑</a>"+"|"+
		  		 			"<a href='#' name = '删除'>删除</a>");
		  		 			out.print("</td>");
		  		 			out.print("<td>");
		  		 			out.print(customer.getFirst_name());
		  		 			out.print("</td>");
		  		 			out.print("<td>");
		  		 			out.print(customer.getLast_name());
		  		 			out.print("</td>");
		  		 			out.print("<td>");
		  		 			out.print(customer.getAddress_id());
		  		 			out.print("</td>");
		  		 			out.print("<td>");
		  		 			out.print(customer.getEmail());
		  		 			out.print("</td>");
		  		 			out.print("<td>");
		  		 			out.print(customer.getCustomer_id());
		  		 			out.print("</td>");
		  		 			out.print("<td>");
		  		 			out.print(customer.getLast_update());
		  		 			out.print("</td>");
		  					out.print("</tr>");
						}
						
					 %>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
