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
<h3>Book List</h3>
<a href="BookServlet?action=new">New Book</a>
<table>
	<thead>
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Qty</th>
			<th>Category Name</th>
			<th>Photo</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${bookList}" var="b" varStatus="row">
		<tr>
		<td>${row.count}</td>
			<td>${b.name }</td>
			<td>${b.qty }</td>
			<td>${b.categoryName }</td>
			<td><img src="./upload_images/${b.photo }" width="80" height="80" /></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>