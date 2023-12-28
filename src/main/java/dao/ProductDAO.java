package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
import sql.connection.DBConnection;

public class ProductDAO {
	public List<Product> getLatestProducts() throws SQLException {

		// connect to mySQL Server
		Connection connection = DBConnection.makeConnection();
		Statement stmt = connection.createStatement();

		String SQL = "select * from product where is_new = 1";
		ResultSet resultSet = stmt.executeQuery(SQL);

		List<Product> list = new ArrayList<Product>();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int price = resultSet.getInt("price");
			String imgName = resultSet.getString("img_name");
			boolean isNew = resultSet.getBoolean("is_new");
			Product product = new Product(id, name, price, imgName, isNew);
			list.add(product);
		}
		return list;
	}

	// write function to get product by ID
	public static Product getProductById(int productId) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		Statement stmt = connection.createStatement();

		String SQL = "select * from product where id = ?";

		PreparedStatement preStmt = connection.prepareStatement(SQL);
		preStmt.setInt(1, productId);

		ResultSet resultSet = preStmt.executeQuery();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int price = resultSet.getInt("price");
			String imgName = resultSet.getString("img_name");
			String productDescription = resultSet.getString("description");
			int quantiy = resultSet.getInt("quantity");

			Product product = new Product(id, name, price, imgName, productDescription, quantiy);
			return product;
		}
		return null;
	}

	// Write function to show all products
	public static List<Product> showAllProducts() throws SQLException {
		Connection connection = DBConnection.makeConnection();
		Statement stmt = connection.createStatement();

		String showProductSQL = "select * from product";
		ResultSet resultSet = stmt.executeQuery(showProductSQL);

		List<Product> list = new ArrayList<Product>();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int price = resultSet.getInt("price");
			String imgName = resultSet.getString("img_name");
			Product product = new Product(id, name, price, imgName);
			list.add(product);
		}
		return list;
	}
}
