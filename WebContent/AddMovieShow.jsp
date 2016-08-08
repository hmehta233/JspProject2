<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><form action="MovieServlet" method = "post">
<table>
<tr> <td colspan="2" align="center"> Add Movie Show</td>
</tr>
<tr>
<td>Add Movie</td>
<td> <input type ="text" name="movieName"  required ></td></tr>
<tr><td>Theater Name</td>
<td><input type = "text" name ="movieTheatre"  required></td></tr>
<tr><td>Total Seats Available</td>
<td><input type = "number" name ="availSeats"  required></td></tr>
<tr><td>Start Time</td>

<td><input type = "time" name ="startTime"  required></td>

</tr>

<tr><td>End Time</td>
<td><input type = "time" name ="endTime"  required></td></tr>

<tr><td colspan="2" align="center">
<input type="submit" value="add" name="submit">
</td></tr></table></form>

<form action="BookTicket.jsp" method="post">
	<input type="submit" value="Book Tickets" name="book">
</form>

<form action="DisplayServlet" method="post">
	<input type="submit" value="Display Movies" name="display">
</form>
<form action="BookingHistory.jsp" method="post">
	<input type="submit" value="Booking History" name="bookinghistory">
</form>
<form action="Logout" method="post">
	<input type="submit" value="Logout" name="logout">
</form>

</center>

</body>
</html>