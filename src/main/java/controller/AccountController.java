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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String userName = request.getParameter("userName");
			String userPass = request.getParameter("userPass");

			User currentUser = UserDAO.validAccount(userName, userPass, request);
			String action = request.getParameter("action");

			if (("login".equals(action))) {
				if (currentUser != null) {
					RequestDispatcher rd = request.getRequestDispatcher("Home");
					request.getSession().setAttribute("currentUser", currentUser);
					rd.forward(request, response);
					return;
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
					rd.forward(request, response);
				}
			} else if (("register".equals(action))) {
				String firstName = request.getParameter("userFirstName");
				String lastName = request.getParameter("userLastName");
				String email = request.getParameter("userEmail");

				User newUser = UserDAO.registerNewUser(firstName, lastName, email, userName, userPass, request);
				if (newUser != null) {
					RequestDispatcher rd = request.getRequestDispatcher("Home");
					request.getSession().setAttribute("newUser", newUser);
					rd.forward(request, response);
					return;
				} else {
	                RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
	                rd.forward(request, response);
	            }
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

}
