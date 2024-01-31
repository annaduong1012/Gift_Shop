<%@page import="dao.CategoryDAO"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductDAO"%>
<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Basic -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<!-- Site Metas -->
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="author" content="" />
<link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">

<title>Giftos</title>

<!-- slider stylesheet -->
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

<!-- bootstrap core css -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet" />
<!-- responsive style -->
<link href="css/responsive.css" rel="stylesheet" />
</head>

<body>
	<!-- header section starts -->
	<jsp:include page="/header-section.jsp" />
	<!-- end header section -->

	<!-- cart details section -->
	<section class="shop_section layout_padding">
		<div class="container">
			<div class="heading_container heading_center">
				<h2>Your Cart</h2>
			</div>
			<div class="col-sm-9 col-md-6 col-lg-12"></div>
			<c:if test="${not empty sessionScope.cart}">
				<table class="table table-bordered" border="1">
					<thead class="thead-dark">
						<tr>
							<th>Product</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Sub-total</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="productInCart" items="${sessionScope.cart.items}">
							<tr>
								<td>${productInCart.name}</td>
								<td>${productInCart.quantity}</td>
								<td>$${productInCart.price}</td>
								<td>$${productInCart.subTotal}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<!-- Calculate and display the total price -->
				<div class="mt-3">
					<h4>
						Total Price: <span>$${totalPrice}</span>
					</h4>
				</div>
			</c:if>

			<c:if test="${empty sessionScope.cart}">
				<p>Empty Cart</p>
			</c:if>
			<a href="Home" class="btn btn-secondary mt-3">Continue Shopping</a>
		</div>
	</section>

	<!-- end cart details section -->

	<!-- footer section start -->
	<jsp:include page="/footer-section.jsp" />
	<!-- footer section end -->


	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
		
	</script>
	<script src="js/custom.js"></script>

</body>

</html>
