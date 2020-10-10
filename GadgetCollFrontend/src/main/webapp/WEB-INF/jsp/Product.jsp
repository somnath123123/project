<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="CommenHeader.jsp"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="InsertProduct" method="post">
<table align="center">
	<tr bgcolor="pink">
		<td align="center" colspan="2"><h3>Product Detail</h3></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Product Name</td>
		<td><input type="text" name="prodName"/></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Product Desc</td>
		<td><textarea rows="5" cols="30" name="prodDesc"></textarea></td>
	</tr>
	<tr bgcolor="pink">
		<td colspan="2" align="center">
			<input type="submit" value="Insert Product"/>
		</td>
	</tr>
</table>
</form>

<table align="center">
	<tr bgcolor="pink">
		<td>Product ID</td>&nbsp;&nbsp;|&nbsp;&nbsp;
		<td>Product Name</td>&nbsp;&nbsp;|&nbsp;&nbsp;
		<td>Product Desc</td>&nbsp;&nbsp;|&nbsp;&nbsp;
		<td>Operation</td>
	</tr>
	<c:forEach items="${productList}" var="product">
	<tr bgcolor="cyan">
		<td>${product.productId}</td>
		<td>${product.productName}</td>
		<td>${product.productDesc}</td>
		<td>
			<a href="deleteproduct/${product.productId}">Delete</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="editproduct/${product.productId}">Edit</a>
		</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>