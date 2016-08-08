
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In | Ticket Booking</title>
</head>
<body>
<center><form action="LoginServlet" method ="post">
			
				
<c:forEach var="message" items="${messages}">
	<p>${ message.value }</p>
</c:forEach>
<table>
<tr> <td colspan="2" align="center"> Login Form</td>
</tr>
<tr>
<td>username</td>
<td> <input type ="email" name="username" id="user" ></tr>
<tr><td>password</td>
<td><input type = "password" name ="password" id="password" ></tr>
<tr><td colspan="2" align="center">
<input type="submit" value="Login" name="Login">
</td></tr></table></form>
</center>
</body>
</html>