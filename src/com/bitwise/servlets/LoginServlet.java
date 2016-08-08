package com.bitwise.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitwise.validate.Validate;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Map<String, String> messages = new HashMap<String, String>();
		UserAuthentication user = new UserAuthentication();

		if (Validate.isValidEmail(username) && !(Validate.isEmpty(password))
				&& user.CheckIfUserIsAvailable(username, password)) {
			System.out.println("user is valid");
			request.getSession(true).setAttribute("username", username);
			response.sendRedirect("AddMovieShow.jsp");
		} else {

			messages.put("username", "Please enter valid username or password.");
			request.setAttribute("messages", messages);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}

		// doGet(request, response);
	}

}
