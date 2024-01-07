package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import entity.Product;
import entity.User;
import sql.connection.DBConnection;

public class UserDAO {

	// Return login account
	public static User validAccount(String userName, String userPassword, HttpServletRequest request)
			throws SQLException {

		// if this is not a POST request, ignore error message
		if (!"POST".equalsIgnoreCase(request.getMethod())) {
			return null;
		}

		Connection connection = DBConnection.makeConnection();
		Statement stmt = connection.createStatement();

		String checkIfUserExistSQL = "select * from user where username = ?;";

		PreparedStatement preStmt = connection.prepareStatement(checkIfUserExistSQL);
		preStmt.setString(1, userName);

		ResultSet resultSet = preStmt.executeQuery();
		if (resultSet.next()) {
			User currentUser = new User();
			currentUser.setId(resultSet.getInt("id"));
			currentUser.setUserName(resultSet.getString("username"));
			currentUser.setUserPassword(resultSet.getString("password"));
			currentUser.setFirstName(resultSet.getString("first_name"));
			currentUser.setLastName(resultSet.getString("last_name"));
			currentUser.setFailedLogin(resultSet.getInt("failed_login"));

			if (currentUser.getFailedLogin() >= 3) {
				request.setAttribute("errorMessage",
						"Your account has been locked. Please contact Support to unlock your account.");
			} else if (userPassword.equals(currentUser.getUserPassword())) {
				request.setAttribute("welcomeMessage",
						"Welcome " + currentUser.getFirstName() + "! You have logged in successfully.");
				return currentUser;
			} else {
				request.setAttribute("errorMessage", "Invalid password. Please try again");
				int failedCount = currentUser.getFailedLogin() + 1;
				currentUser.setFailedLogin(failedCount);
				// Update failed count
				updateFailedCount(userName, failedCount);
			}
		} else {
			request.setAttribute("errorMessage", "Invalid Account, please try again");
		}
		return null;
	}

	// Update failed login attempt
	public static void updateFailedCount(String userName, int failedCount) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		Statement stmt = connection.createStatement();

		String updateFailedAttemptSQL = "UPDATE user SET failed_login = ? WHERE username = ?;";

		PreparedStatement updateStmt = connection.prepareStatement(updateFailedAttemptSQL);
		updateStmt.setInt(1, failedCount);
		updateStmt.setString(2, userName);
		updateStmt.executeUpdate();
	}

	// Get user details from userID
	public static User getUserById(String userId) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		Statement stmt = connection.createStatement();

		String SQL = "select * from user where id = ?";

		PreparedStatement preStmt = connection.prepareStatement(SQL);
		preStmt.setInt(1, Integer.parseInt(userId));

		ResultSet resultSet = preStmt.executeQuery();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");

			User currentUser = new User(id, firstName, lastName);
			return currentUser;
		}
		return null;
	}
}
