<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="CommenHeader.jsp"%>
<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="InsertSupplier" method="post">
<table align="center">
	<tr bgcolor="pink">
		<td align="center" colspan="2"><h3>Supplier Detail</h3></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Supplier Name</td>
		<td><input type="text" name="supName"/></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Supplier Desc</td>
		<td><textarea rows="5" cols="30" name="supDesc"></textarea></td>
	</tr>
	<tr bgcolor="pink">
		<td colspan="2" align="center">
			<input type="submit" value="Insert Supplier"/>
		</td>
	</tr>
</table>
</form>

<table align="center">
	<tr bgcolor="pink">
		<td>Supplier ID</td>
		<td>Supplier Name</td>
		<td>Supplier Desc</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${supplierList}" var="supplier">
	<tr bgcolor="cyan">
		<td>${supplier.supplierId}</td>
		<td>${supplier.supplierName}</td>
		<td>${supplier.supplierDesc}</td>
		<td>
			<a href="deletesupplier/${supplier.supplierId}">Delete</a>&nbsp;&nbsp;/&nbsp;&nbsp;
			<a href="editsupplier/${supplier.supplierId}">Edit</a>
		</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>