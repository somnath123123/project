<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="CommenHeader.jsp"%>
<br><br><<br><br>
<form action="<c:url value="${PageContext}/UpdateCategory"/>" method="post">
	<table align="center" width="40%" height="40%">
	<tr bgcolor="PaleTurquoise">
		<td align="center" colspan="2"><h3>Category Detail</h3></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Category Id</td>
		<td><input type="text" name="catId" value="${category.categoryId}" readonly/></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Category Name</td>
		<td><input type="text" name="catName" value="${category.categoryName}"/></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Category Desc</td>
		<td><textarea rows="5" cols="30" name="catDesc">${category.categoryDesc}</textarea></td>
	</tr>
	
	<tr bgcolor="LightCyan">
		<td colspan="2" align="center">
			<input type="submit" value="Update Category"/>
		</td>
	</tr>
</table>
</form>


</body>
</html>