package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

/**
 * Servlet implementation class AuthenticationController
 */
@WebServlet("/Authentication")
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AuthenticationController() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String action = request.getParameter("action");

			if (action == null) {
				action = "DEFAULT";
			}

			switch (action) {
			case "LOGIN": {
				doLogin(request, response);
				break;
			}
			case "LOGOUT": {
				HttpSession session = request.getSession();
				session.removeAttribute("user");
				response.sendRedirect("Home");
				break;
			}
			default: {
				break;
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");

		User user = UserDAO.validAccount(userName, userPass, request);

		if (user != null) {
			RequestDispatcher rd = request.getRequestDispatcher("Home");
			request.getSession().setAttribute("user", user);
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}
}
