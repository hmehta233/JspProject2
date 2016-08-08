package com.bitwise.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitwise.model.Movie;
import com.bitwise.model.Movies;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
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
	
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String movieName = request.getParameter("movieName");
			String movieTheatre = request.getParameter("movieTheatre");
			String availSeats = request.getParameter("availSeats");
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String submit = request.getParameter("submit");
			
			System.out.println("Inside movie handler: " + submit);
			if (submit.equals("add")) {
				if (request.getSession(false).getAttribute("movies") == null) {
					System.out.println("Inside If");
					Movies movies = new Movies();
					Movie movie = new Movie();
					movie.setMovieName(movieName);
					movie.setTheater(movieTheatre);
					movie.setTotalSeats(availSeats);
					movie.setStartTime(startTime);
					movie.setEndTime(endTime);
					movies.addMovie(movie);
					System.out.println(movie.getEndTime());
					
					request.getSession(false).setAttribute("movies", movies);
				} else {
					Movies movies = (Movies) request.getSession(false).getAttribute("movies");
					
						Movie movie = new Movie();
						movie.setMovieName(movieName);
						movie.setTheater(movieTheatre);
						movie.setTotalSeats(availSeats);
						movie.setStartTime(startTime);
						movie.setEndTime(endTime);
						movies.addMovie(movie);
						movie.getMovieName();
						request.getSession(false).setAttribute("movies", movies);
					
					
				}
			}
			
			if (submit.equals("remove")) {
				System.out.println("inside remove if");
				Movies movies = (Movies) request.getSession(false).getAttribute("movies");
				Movie movie = new Movie();
				movie.setMovieName(movieName);
				movie.setTheater(movieTheatre);
				movie.setTotalSeats(availSeats);
				movie.setStartTime(startTime);
				movie.setEndTime(endTime);
				movies.removeMovie(movie);
				request.getSession(false).setAttribute("movies", movies);

			}
			
			request.getRequestDispatcher("display.jsp").forward(request, response);
//			response.sendRedirect("DisplayServlet");
		}
	}


