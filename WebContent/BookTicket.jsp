<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="t" uri="../WEB-INF/tags.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Ticket | Ticket Booking System</title>
</head>
<body>
<center><form action="BookMovie" method = "post">
<table>
<tr> <td colspan="2" align="center"> Add Movie Show</td>
</tr>
<tr>
<td>Customer Name</td>
<td> <input type ="text" name="custname"  required autofocus></tr>
<tr><td>Customer Address</td>
<td><input type = "text" name ="custadd"  required></tr>
<tr><td>Customer Phone</td>
<td><input type = "number" name ="custphone"  required></tr>
<tr><td>Movie Show</td>
<td>
<t:moviesNamesList/>
</td>
<tr><td>Date</td>
<td><input type = "date" name ="date"  required></tr>
<tr><td>NO of seats booked</td>
<td><input type = "number" name ="seatsbooked"  required></tr>


<tr><td colspan="2" align="center">
<input type="submit" value="book" name="book">
</td></tr></table></form>
</center>


</body>
</html>