package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import dao.ProductDAO;
import entity.Cart;
import entity.Product;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/Cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String action = request.getParameter("ACTION");

			switch (action) {
			case "ADD_TO_CART": {
				addToCart(request, response);
				break;
			}
			case "VIEW_CART": {
				viewCart(request, response);
				break;
			}
			default:
				break;
			}
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String productId = request.getParameter("productId");

		Cart cart;
		HttpSession session = request.getSession();

		if (session.getAttribute("cart") == null) {
			cart = new Cart();
			cart.setItems(new HashMap<Product, Integer>());
		} else {
			cart = (Cart) session.getAttribute("cart");
		}

		// check if object Product exist in cart.getproductid
		Product product = ProductDAO.getProductById(productId);

		if (cart.getItems().containsKey(product)) {
			int newQuantity = cart.getItems().get(product) + 1;
			cart.getItems().put(product, newQuantity);
		} else {
			cart.getItems().put(product, 1);
		}

		for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
			System.out.println("PRODUCT " + entry.getKey().getName());
			System.out.println("PRICE " + entry.getKey().getPrice());
			System.out.println("Quantity " + entry.getValue());
			System.out.println("--------");

		}

		session.setAttribute("cart", cart);
		response.sendRedirect("Product?productId=" + productId);

	}

	private void viewCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		// Calculate total price 
		double totalPrice = CartDAO.calculateTotalPrice(cart.getItems());
		request.setAttribute("totalPrice", totalPrice);

		// Forward to the cart.jsp page
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
}
