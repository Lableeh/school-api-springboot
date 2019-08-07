<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>Insert title here</title>
</head>
<body>

	<form action="addAdviser">
		Adviser ID:<br>
		<input type="text" name="adviserId"><br>
		FirstName:<br>
		<input type="text" name="firstName"><br>
		LastName:<br>
		<input type="text" name="lastName"><br>
		Age:<br>
		<input type="text" name="age"><br>
		Gender:<br>
		<input type="text" name="gender"><br>
		<input type="submit"><br>
	</form>
	
	<form action="getAdviser">
		<br><br>Adviser ID:<br>
		<input type="text" name="adviserId"><br>
		<input type="submit"><br>
	</form>
	
</body>
</html>