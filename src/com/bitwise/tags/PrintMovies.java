package com.bitwise.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.bitwise.model.Movie;
import com.bitwise.model.Movies;

public class PrintMovies extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		//PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		//HttpServletResponse response = (HttpServletResponse)pageContext.getResponse();
		JspWriter out = pageContext.getOut();
		Movies movieList =(Movies)request.getSession(false).getAttribute("movies");
		
		try {
			if (movieList != null) {
				List<Movie> movies = movieList.getMovies();		
				if (movies != null) {
					
					out.println("<select id='selectedRecord' name='show'>");
					for(Movie m : movies ){
						out.println("<option value='" + m.getMovieName() + "'>"+m.getMovieName() + "</option>");
					}
					out.println("</select>");
				}else{
					out.println("<select id='selectedRecord' name='show'>"
							+ "<option value='novalue'>--</option>"
							+ "</select>");
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
  }
	
}
