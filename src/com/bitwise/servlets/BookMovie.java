package com.bitwise.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitwise.model.Booking;
import com.bitwise.model.BookingList;

/**
 * Servlet implementation class BookMovie
 */
@WebServlet("/BookMovie")
public class BookMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookMovie() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in book movie");
		//response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String custName = request.getParameter("custname");
		String address = request.getParameter("custadd");
		String phone = request.getParameter("custphone");
		String seats = request.getParameter("seatsbooked");
		String date = request.getParameter("date");
		String movieShow = request.getParameter("show");
		HttpSession session = request.getSession(false);
		if (request.getParameter("book").equalsIgnoreCase("book")) {
			BookingList bookingList;
			if (request.getSession(false).getAttribute("bookingList") == null) {
				System.out.println("here");
	
				bookingList = new BookingList();
				Booking newBooking = new Booking();
				newBooking.setCustName(custName);
				newBooking.setAddress(address);
				newBooking.setContactNumber(phone);
				newBooking.setDate(date);
				newBooking.setMovishow(movieShow);
				newBooking.setNoOfSeatsBooked(seats);
				bookingList.addBooking(newBooking);
				request.getSession(false).setAttribute("bookingList", bookingList);
			} else {
				bookingList = (BookingList)session.getAttribute("bookingList");
				Booking newBooking = new Booking();
				newBooking.setCustName(custName);
				newBooking.setAddress(address);
				newBooking.setContactNumber(phone);
				newBooking.setDate(date);
				newBooking.setMovishow(movieShow);
				newBooking.setNoOfSeatsBooked(seats);
				bookingList.addBooking(newBooking);
			}
			session.setAttribute("bookingList", bookingList);
		}
		
		request.getRequestDispatcher("BookingHistory.jsp").forward(request, response);
		
		
	}

}
