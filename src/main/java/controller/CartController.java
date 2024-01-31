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
import entity.ProductInCart;

import java.util.HashSet;

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
			cart.setItems(new HashSet<ProductInCart>());
		} else {
			cart = (Cart) session.getAttribute("cart");
		}

		// check if object Product exist in cart.getproductid
		Product product = ProductDAO.getProductById(productId);
		ProductInCart productInCart = new ProductInCart(product.getId(), product.getName(), product.getPrice(),
				product.getPrice(), 1);

		if (cart.getItems().contains(productInCart)) {
			for (ProductInCart item : cart.getItems()) {
				if (item.getId() == productInCart.getId()) {
					productInCart.setQuantity(item.getQuantity() + 1);
					productInCart.setSubTotal(item.getQuantity() * productInCart.getPrice());
				}
			}

			// remove old key to replace with new key
			cart.getItems().remove(productInCart);
			cart.getItems().add(productInCart);
		} else {
			cart.getItems().add(productInCart);
		}
		cart.setTotal(cart.getTotal() + product.getPrice());
		session.setAttribute("cart", cart);
		response.sendRedirect("Product?productId=" + productId);

	}

	private void viewCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		if (cart != null && cart.getItems() != null) {
			double totalPrice = cart.getTotal();
			request.setAttribute("totalPrice", totalPrice);
		} else {
			// When cart or items is null
			request.setAttribute("totalPrice", 0.0);
		}

		// Forward to the cart.jsp page
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
}
