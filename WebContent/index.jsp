<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="LoginController">
	   <table>
		<tr><td>User Name:</td>
			<td><input name = "user" id = "user" type="text"></input></td>
		</tr>
		<tr><td>Password: </td>
			<td><input name = "password" id = "password" type="password"></input>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Submit"></input></td>
			<td><input type="reset" value="Clear"></input></td>
			</table>
	</form>

</body>
</html>