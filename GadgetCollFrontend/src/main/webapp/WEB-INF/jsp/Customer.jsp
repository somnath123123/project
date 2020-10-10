<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="CommenHeader.jsp"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="InsertCustomer" method="post">
<table align="center">
	<tr bgcolor="pink">
		<td align="center" colspan="2"><h3>customer Detail</h3></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Login Name</td>
		<td><input type="text" name="logName"/></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Password</td>
		<td><textarea rows="5" cols="30" name="pass"></textarea></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Customer Name</td>
		<td><textarea rows="5" cols="30" name="custName"></textarea></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Email ID</td>
		<td><textarea rows="5" cols="30" name="emailId"></textarea></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Mobile No</td>
		<td><textarea rows="5" cols="30" name="mobileNo"></textarea></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Customer Address</td>
		<td><textarea rows="5" cols="30" name="custAddr"></textarea></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Role</td>
		<td><textarea rows="5" cols="30" name="role"></textarea></td>
	</tr>
	<tr bgcolor="pink">
		<td colspan="2" align="center">
			<input type="submit" value="Insert Customer"/>
		</td>
	</tr>
</table>
</form>

<table align="center">
	<tr bgcolor="pink">
		<td>Customer ID</td>
		<td>Login Name</td>
		<td>Password</td>
		<td>Customer Name</td>
		<td>Email ID</td>
		<td>Mobile No</td>
		<td>Customer Address</td>
		<td>Role</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${customerList}" var="customer">
	<tr bgcolor="cyan">
		<td>${customer.customerId}</td>
		<td>${customer.loginName}</td>
		<td>${customer.password}</td>
		<td>${customer.customerName}</td>
		<td>${customer.emailId}</td>
		<td>${customer.mobileNo}</td>
		<td>${customer.customerAddr}</td>
		<td>${customer.role}</td>
		<td>
			<a href="deletecustomer/${customer.customerId}">Delete</a>&nbsp;&nbsp;/&nbsp;&nbsp;
			<a href="editcustomer/${customer.customerId}">Edit</a>
		</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>