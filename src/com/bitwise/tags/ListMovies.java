package com.bitwise.tags;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.bitwise.model.Movie;
import com.bitwise.model.Movies;

public class ListMovies extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		PrintWriter out = response.getWriter();
		Movies movies = (Movies) request.getSession(false).getAttribute("movies");
		
		out.println("<form action=\"Logout\" method=\"post\"><input type=\"submit\" value=\"Logout\" name=\"logout\"></form>");
		out.println("<form action=\"AddMovieShow.jsp\" method=\"post\"><input type=\"submit\" value=\"Add Movie Show\" name=\"Add Movie Show\"></form>");
		
		if (movies != null && movies.getMovies().size() > 0) {
			for (Movie movie: movies.getMovies()) {
				response.setContentType("text/html");
				out.println("<form action='MovieServlet' method='post'> ");
				out.println("<input type='hidden' name='movieName' value='"+movie.getMovieName()+"' />");
				out.println("<input type='hidden' name='movieTheatre' value='"+movie.getTheater()+"' />");
				out.println("<input type='hidden' name='availSeats' value='"+movie.getTotalSeats()+"' />");
				out.println("<input type='hidden' name='startTime' value='"+movie.getStartTime()+"' />");
				out.println("<input type='hidden' name='endTime' value='"+movie.getEndTime()+"' />");
				out.println("<centre>");
				out.println("<table>");
				out.println("<tr>" );
				out.println("<td>");
				out.println("Movie name -" +movie.getMovieName());
				out.println("</td>");
				out.println("</tr>");
				out.println("<tr>" );
				out.println("<td>");
				out.println("Theatre name-" +movie.getTheater());
				out.println("</tr>" );
				out.println("</td>");
				out.println("<tr>" );
				out.println("<td>");
				out.println("Total seats-" +movie.getTotalSeats());
				out.println("</tr>" );
				out.println("</td>");
				out.println("<tr>" );
				out.println("<td>");	
				out.println("Start Time-" +movie.getStartTime());
				out.println("</tr>" );
				out.println("</td>");
				out.println("<tr>" );
				out.println("<td>");	
				out.println("End Time-" +movie.getEndTime());
				out.println("</tr>" );
				out.println("</td>");
				out.println("<table>");
				out.println("</centre>");
				out.println("<input type='submit' name='submit' value='remove' />");
				out.println("</form>");
			}
		}else{
			response.setContentType("text/html");
			out.println("<p>Please add Movie shows first.</p>");
		}
		out.flush();
		super.doTag();
	}
}
