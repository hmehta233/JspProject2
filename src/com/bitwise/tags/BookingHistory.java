package com.bitwise.tags;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.bitwise.model.Booking;
import com.bitwise.model.BookingList;

public class BookingHistory extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		PrintWriter out = response.getWriter();
		BookingList bookings = (BookingList) request.getSession(false).getAttribute("bookingList");
		out.println(
				"<form action=\"Logout\" method=\"post\"><input type=\"submit\" value=\"Logout\" name=\"logout\"></form>");
		out.println(
				"<form action=\"AddMovieShow.jsp\" method=\"post\"><input type=\"submit\" value=\"Back\" name=\"Back\"></form>");
		if (bookings == null) {
			System.out.println("Bookings null");
		}

		if (bookings != null && bookings.getBookings().size() > 0) {
			for (Booking booking : bookings.getBookings()) {
				response.setContentType("text/html");

				out.println("<centre>");
				out.println("<table>");
				out.println("<tr>");
				out.println("<td>");
				out.println("Customer Name -" + booking.getCustName());
				out.println("</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>");
				out.println("Address-" + booking.getAddress());
				out.println("</tr>");
				out.println("</td>");
				out.println("<tr>");
				out.println("<td>");
				out.println("Date-" + booking.getDate());
				out.println("</tr>");
				out.println("</td>");
				out.println("<tr>");
				out.println("<td>");
				out.println("Movie Show-" + booking.getMovishow());
				out.println("</tr>");
				out.println("</td>");
				out.println("<tr>");
				out.println("<td>");
				out.println("No of Seats Booked-" + booking.getNoOfSeatsBooked());
				out.println("</tr>");
				out.println("</td>");
				out.println("<table>");
				out.println("</centre>");
			}
		} else {
			response.setContentType("text/html");
			out.println("<p>There are no bookings made till now.</p>");
		}
		out.flush();
		super.doTag();
	}
}
