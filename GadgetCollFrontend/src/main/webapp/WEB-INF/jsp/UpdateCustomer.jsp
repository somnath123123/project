<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="CommenHeader.jsp"%>
<br><br><<br><br>
<form action="<c:url value="${PageContext}/UpdateCustomer"/>" method="post">
	<table align="center" width="40%" height="40%">
	<tr bgcolor="PaleTurquoise">
		<td align="center" colspan="2"><h3>customer Detail</h3></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Customer Id</td>
		<td><input type="text" name="custId" value="${customer.customerId}" readonly/></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Customer Name</td>
		<td><input type="text" name="custName" value="${customer.customerName}"/></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Customer Desc</td>
		<td><textarea rows="5" cols="30" name="custDesc">${customer.customerDesc}</textarea></td>
	</tr>
	
	<tr bgcolor="LightCyan">
		<td colspan="2" align="center">
			<input type="submit" value="Update Customer"/>
		</td>
	</tr>
</table>
</form>


</body>
</html>