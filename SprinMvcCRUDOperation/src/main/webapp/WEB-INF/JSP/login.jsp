<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${msg}
	<form action="login">
		USERNAME: <input type="text" name ="uname"><br>
		PASSWORD: <input type="text" name="password"><br>
		<input type="submit" value="SUBMIT"> &nbsp; &nbsp; <a href="registrationPage">Register USER</a>
	</form>
</body>
</html>