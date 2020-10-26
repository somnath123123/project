<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="CommenHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="LightCyan">
<br><br><<br><br>
	<form action="InsertProduct" method="post">
<table align="center" width="40%" height="40%">
	<tr bgcolor="PaleTurquoise">
		<td align="center" colspan="2"><h3>Product Detail</h3></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Product Name</td>
		<td><input type="text" name="prodName"/></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Product Desc</td>
		<td><textarea rows="5" cols="30" name="prodDesc"></textarea></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Category Id</td>
		<td><input type="text" name="catId"/></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Supplier Id</td>
		<td><input type="text" name="supId"/></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Price</td>
		<td><input type="text" name="prc"/></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Stock</td>
		<td><input type="text" name="stc"/></td>
	</tr>
	<tr bgcolor="LightCyan">
		<td colspan="2" align="center">
			<input type="submit" value="Insert Product"/>
		</td>
	</tr>
</table>
</form>

<table align="center" width="80%" height="40%">
	<tr bgcolor="LightCyan">
		<td>Product ID</td>
		<td>Product Name</td>
		<td>Product Desc</td>
		<td>Category ID</td>
		<td>Supplier Id</td>
		<td>Price</td>
		<td>Stock</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${productList}" var="product">
	<tr bgcolor="MistyRose">
		<td>${product.productId}</td>
		<td>${product.productName}</td>
		<td>${product.productDesc}</td>
		<td>${product.categoryId}</td>
		<td>${product.supplierId}</td>
		<td>${product.price}</td>
		<td>${product.stock}</td>
		<td>
			<a href="deleteProduct/${product.productId}" class="btn btn-danger">Delete</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="editProduct/${product.productId}" class="btn btn-success">Edit</a>
		</td>
	</tr>
	</c:forEach>
</table>
	

</body>
</html>