package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

/**
 * Servlet implementation class AccountController
 */
@WebServlet("/Account")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAO = new UserDAO();
	User user;

	public AccountController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = request.getParameter("action");
//		
//		if (("LOGOUT").equals(action)) {
//			request.getSession().invalidate();
//			response.sendRedirect("Home");
//		} else {
//			return;
//		}
		
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
				user = validUser(request, response);
				dispatchToView(request, response);
				break;
			}
			case "REGISTER": {
				user = registeredUser(request, response);
				dispatchToView(request, response);
				break;
			}
			case "LOGOUT": {
				request.getSession().invalidate();
				response.sendRedirect("Home");
				break;
			}
			default: {
				return;
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	private User validUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");

		return UserDAO.validAccount(userName, userPass, request);
	}

	private User registeredUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		String firstName = request.getParameter("userFirstName");
		String lastName = request.getParameter("userLastName");
		String email = request.getParameter("userEmail");

		return UserDAO.registerNewUser(firstName, lastName, email, userName, userPass, request);
	}

	private void dispatchToView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (user != null) {
			dispatchSuccessAttempt(request, response);
		} else {
			dispatchFailedAttempt(request, response);
		}
	}

	private void dispatchSuccessAttempt(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Home");
		request.getSession().setAttribute("user", user);
		rd.forward(request, response);
	}

	private void dispatchFailedAttempt(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
		rd.forward(request, response);
	}

}
