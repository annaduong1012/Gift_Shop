package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Category;
import entity.Product;
import sql.connection.DBConnection;

public class CategoryDAO {
	// Write function to show list of category
	public static List<Category> showCategory() throws SQLException {
		Connection connection = DBConnection.makeConnection();
		Statement stmt = connection.createStatement();

		String showCategorySQL = "select * from category;";
		ResultSet resultSet = stmt.executeQuery(showCategorySQL);

		List<Category> list = new ArrayList<Category>();

		while (resultSet.next()) {
			String categoryName = resultSet.getString("category_name");
			int categoryId = resultSet.getInt("id");
			Category category = new Category(categoryId, categoryName);
			list.add(category);
		}
		return list;
	}

}
