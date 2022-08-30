<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<table border="1" style="align-items: center;">

		<tbody  style="align-items: center;">
			<th>UID</th>
			<th>Name</th>
			<th>UName</th>
			<th>Password</th>
			<c:forEach items="${userList}" var="user" >
				<tr  style="align-items: center;">
					<td>${user.uid}</td>
						<td>${user.name}</td>
							<td>${user.uname}</td>
								<td>${user.password}</td>
								<td><a href="${pageContext.request.contextPath}/delete/${user.uid}">DELETE</a></td>
								<td><a href="${pageContext.request.contextPath}/edit/${user.uid}">EDIT</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</center>
</body>
</html>