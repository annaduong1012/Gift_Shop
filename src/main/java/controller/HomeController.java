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
			// Use Model to get data
			CategoryDAO categoryDAO = new CategoryDAO();
			ProductDAO productDAO = new ProductDAO();
			List<Category> categoryList = CategoryDAO.showCategory();
			List<Product> productList;
			String categoryId = request.getParameter("categoryId");
			String showAll = request.getParameter("action");
			String searchQuery = request.getParameter("searchField");

			if (("show_all_products").equals(showAll)) {
				productList = productDAO.showAllProducts();
			} else if (categoryId == null || categoryId.isEmpty()) {
				productList = productDAO.getLatestProducts();
			} else {
				productList = productDAO.getProductByCategoryId(categoryId);
			}

			// Send DATA to index.jsp
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("categoryList", categoryList);
			if (searchQuery != null && !searchQuery.isEmpty()) {
				request.setAttribute("productBySearchQuery", ProductDAO.getProductBySearch(searchQuery));
			} else {
				request.setAttribute("productList", productList);
				request.setAttribute("categoryId", categoryId);
				request.setAttribute("showAll", showAll);

			}
			rd.forward(request, response);
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

}
