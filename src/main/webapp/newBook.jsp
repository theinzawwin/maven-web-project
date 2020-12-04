<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Create New book</h3>
<div>
<form action="BookServlet" method="post" enctype="multipart/form-data">
<table>
	<tr>
		<td>Name:</td>
		<td><input type="text" name="name" />
	</tr>
	<tr>
		<td>Category:</td>
		<td>
		<select name="categoryId">
			<c:forEach items="${categoryList }" var="cat">
				<option value="${cat.id}">${cat.name }</option>
			</c:forEach>
		</select>
	</tr>
	<tr>
		<td>Qty:</td>
		<td><input type="number" name="qty" />
	</tr>
	<tr>
		<td>Photo:</td>
		<td><input type="file" name="photo" />
	</tr>
	<tr>
	<td colspan="2">
		<input type="submit" value="Save" />
		<a href="BookServlet?action=list">Book List</a>
	</td>
	</tr>
</table>

</form>
</div>
</body>
</html>