package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/Home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryDAO categoryDAO = new CategoryDAO();
	ProductDAO productDAO = new ProductDAO();
	List<Category> categoryList;
	List<Product> productList;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			categoryList = CategoryDAO.showCategory();
			String action = request.getParameter("action");

			if (action == null) {
				action = "DEFAULT";
			}
			switch (action) {
			case "SHOW_ALL_PRODUCTS": {
				productList = productDAO.showAllProducts();
				break;
			}
			case "SHOW_PRODUCT_BY_CATEGORY": {
				String categoryId = request.getParameter("categoryId");
				productList = productDAO.getProductByCategoryId(categoryId);
				break;
			}
			case "SEARCH": {
				String searchQuery = request.getParameter("searchField");
				productList = ProductDAO.getProductBySearch(searchQuery);
				break;
			}
			default: {
				productList = productDAO.getLatestProducts();
				break;
			}
			}

			// Send DATA to index.jsp
			dispatchAttributeToView(request, response);
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void dispatchAttributeToView(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("productList", productList);
		rd.forward(request, response);
	}
}
