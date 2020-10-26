<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="CommenHeader.jsp"%>
<br><br><<br><br>
<form action="<c:url value="${PageContext}/UpdateSupplier"/>" method="post">
	<table align="center">
	<tr bgcolor="PaleTurquoise">
		<td align="center" colspan="2"><h3>Supplier Detail</h3></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Supplier Id</td>
		<td><input type="text" name="supId" value="${supplier.supplierId}" readonly/></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Supplier Name</td>
		<td><input type="text" name="supName" value="${supplier.supplierName}"/></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Supplier Desc</td>
		<td><textarea rows="5" cols="30" name="supDesc">${supplier.supplierDesc}</textarea></td>
	</tr>
	
	<tr bgcolor="LightCyan">
		<td colspan="2" align="center">
			<input type="submit" value="Update Supplier"/>
		</td>
	</tr>
</table>
</form>


</body>
</html>