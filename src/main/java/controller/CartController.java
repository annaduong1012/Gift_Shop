package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
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
		String action = request.getParameter("ACTION");

		switch (action) {
		case "ADD_TO_CART": {
			addToCart(request, response);
			break;
		}
		default:
			break;
		}
	}

	@SuppressWarnings("unchecked")
	private void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productId = request.getParameter("productId");

		Set<Integer> shoppingCartProducts;
		HttpSession session = request.getSession();

		if (session.getAttribute("cart") == null) {
			shoppingCartProducts = new HashSet<>();
		} else {
			shoppingCartProducts = (Set<Integer>) session.getAttribute("cart");
		}

		shoppingCartProducts.add(Integer.parseInt(productId));
		session.setAttribute("cart", shoppingCartProducts);
		response.sendRedirect("Product?productId=" + productId);

	}

}
