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
	public static Product getProductById(String productId) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		Statement stmt = connection.createStatement();

		String SQL = "select * from product where id = ?";

		PreparedStatement preStmt = connection.prepareStatement(SQL);
		preStmt.setInt(1, Integer.parseInt(productId));

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

	// Write function to get products by categoryId
	public static List<Product> getProductByCategoryId(String categoryId) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		Statement stmt = connection.createStatement();

		String SQL = "select p.id, name, price, img_name, category_name from product p\n"
				+ "join category c on p.category_id = c.id\n" + "where c.id = ?;";

		PreparedStatement preStmt = connection.prepareStatement(SQL);
		preStmt.setInt(1, Integer.parseInt(categoryId));
		ResultSet resultSet = preStmt.executeQuery();

		List<Product> list = new ArrayList<Product>();

		while (resultSet.next()) {
			int id = resultSet.getInt("p.id");
			String name = resultSet.getString("name");
			int price = resultSet.getInt("price");
			String imgName = resultSet.getString("img_name");
			String categoryName = resultSet.getString("category_name");
			Product product = new Product(id, name, price, imgName, categoryName);
			list.add(product);
		}
		return list;
	}

	// Write function to return result from search query
	public static List<Product> getProductBySearch(String searchQuery) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		Statement stmt = connection.createStatement();

		String SQL = "select * from product\n" + "where name like ?;";

		PreparedStatement preStmt = connection.prepareStatement(SQL);
		preStmt.setString(1, "%" + searchQuery + "%");
		ResultSet resultSet = preStmt.executeQuery();

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
