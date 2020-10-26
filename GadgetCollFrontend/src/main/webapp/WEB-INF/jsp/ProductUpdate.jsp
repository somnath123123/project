
<%@include file="CommenHeader.jsp"%>
<br><br><<br><br>
<form action="<c:url value="${PageContext}/UpdateCategory"/>" method="post">
	<table align="center">
	<tr bgcolor="PaleTurquoise">
		<td align="center" colspan="2"><h3>Product Detail</h3></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Product Id</td>
		<td><input type="text" name="prodId" value="${product.productId}" readonly/></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>product Name</td>
		<td><input type="text" name="prodName" value="${product.productName}"/></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>product Desc</td>
		<td><textarea rows="5" cols="30" name="catDesc" value="${product.productDesc}"></textarea></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Category Id</td>
		<td><input type="text" name="catId" value="${category.categoryId}"></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Supplier Id</td>
		<td><input type="text" name="supId" value="${supplier.supplierId}"></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Price</td>
		<td><input type="text" name="prc" value="${product.price}"></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Stock</td>
		<td><input type="text" name="stc" value="${product.stock}"></td>
	</tr>
	<tr bgcolor="LightCyan">
		<td colspan="2" align="center">
			<input type="submit" value="Update Product"/>
		</td>
	</tr>
</table>
</form>


</body>
</html>