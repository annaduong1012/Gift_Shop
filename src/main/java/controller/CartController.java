package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import entity.Cart;
import entity.Product;

import java.util.HashMap;

@WebServlet("/Cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			if (action == null) {
				action = "DEFAULT";
			}
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
		cart.setTotalPrice(cart.getTotalPrice() + product.getPrice());
		session.setAttribute("cart", cart);
		response.sendRedirect("Product?productId=" + productId);

	}

	private void viewCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		if (cart != null && cart.getItems() != null) {
			double totalPrice = cart.getTotalPrice();
			request.setAttribute("totalPrice", totalPrice);
		} else {
			// When cart or items is null
			request.setAttribute("totalPrice", 0.0);
		}

		// Forward to the cart.jsp page
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
}
