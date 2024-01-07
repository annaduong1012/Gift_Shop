<%@page import="entity.User"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dao.UserDAO"%>
<%@page import="dao.CategoryDAO"%>
<%@page import="entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductDAO"%>
<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<%
// get category list to show in menu bar
CategoryDAO categoryDAO = new CategoryDAO();
pageContext.setAttribute("categoryList", categoryDAO.showCategory());

//login function
String userName = request.getParameter("userName");
String userPass = request.getParameter("userPass");

try {
	User user = UserDAO.validAccount(userName, userPass, request);
	if (user != null) {
		request.getSession().setAttribute("user", user);
		response.sendRedirect("index.jsp?userId=" + user.getId());
		return;
	}
} catch (SQLException e) {
	e.printStackTrace();
	request.setAttribute("errorMessage", "An error occurred. Please try again later.");
}
%>
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
	<div class="hero_area">
		<!-- header section strats -->
		<header class="header_section">
			<nav class="navbar navbar-expand-lg custom_nav-container ">
				<a class="navbar-brand" href="index.jsp"> <span> Giftos </span>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class=""></span>
				</button>

				<!-- search bar -->
				<div class="searchBar">
					<form action="search.jsp" method="get" class="searchForm">
						<div>
							<input type="text" name="searchField"
								placeholder="Search for product" />
							<button class="searchBtn" type="submit">
								<i class="fa fa-search" aria-hidden="true"></i>
							</button>
						</div>
					</form>
				</div>

				<!-- end search bar -->

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav  ">
						<li class="nav-item active"><a class="nav-link"
							href="index.jsp">Home</a></li>
						<c:forEach items="${categoryList}" var="category">
							<li class="nav-item"><a class="nav-link"
								href="index.jsp?categoryId=${category.id}"> ${category.name}
							</a></li>
						</c:forEach>
					</ul>
					<div class="user_option">
						<a href=""> <i class="fa fa-user" aria-hidden="true"></i> <span>
								Login </span>
						</a> <a href=""> <i class="fa fa-shopping-bag" aria-hidden="true"></i>
						</a>
					</div>
				</div>
			</nav>
		</header>
		<!-- end header section -->
	</div>
	<!-- end hero area -->

	<!-- login section -->
	<section class="shop_section layout_padding">
		<div class="container">
			<div class="heading_container heading_center">
				<h2>My Account</h2>
			</div>
			<c:if test="${not empty errorMessage}">
				<p style="color: red;">${errorMessage}</p>
			</c:if>
			<div>
				<form method="post" class="loginForm">
					<label for="username">Username</label><br> <input type="text"
						name="userName" placeholder="Your username" /><br> <label
						for="password">Password</label><br> <input type="text"
						name="userPass" /><br>
					<button class="loginBtn" type="submit">
						<i class="fa fa-user" aria-hidden="true">Login now</i>
					</button>
				</form>
			</div>

		</div>

	</section>
	<!-- end login section -->
	<!-- info section -->

	<section class="info_section  layout_padding2-top">
		<div class="social_container">
			<div class="social_box">
				<a href=""> <i class="fa fa-facebook" aria-hidden="true"></i>
				</a> <a href=""> <i class="fa fa-twitter" aria-hidden="true"></i>
				</a> <a href=""> <i class="fa fa-instagram" aria-hidden="true"></i>
				</a> <a href=""> <i class="fa fa-youtube" aria-hidden="true"></i>
				</a>
			</div>
		</div>
		<div class="info_container ">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-lg-3">
						<h6>ABOUT US</h6>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
							sed doLorem ipsum dolor sit amet, consectetur adipiscing elit,
							sed doLorem ipsum dolor sit amet,</p>
					</div>
					<div class="col-md-6 col-lg-3">
						<div class="info_form ">
							<h5>Newsletter</h5>
							<form action="#">
								<input type="email" placeholder="Enter your email">
								<button>Subscribe</button>
							</form>
						</div>
					</div>
					<div class="col-md-6 col-lg-3">
						<h6>NEED HELP</h6>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
							sed doLorem ipsum dolor sit amet, consectetur adipiscing elit,
							sed doLorem ipsum dolor sit amet,</p>
					</div>
					<div class="col-md-6 col-lg-3">
						<h6>CONTACT US</h6>
						<div class="info_link-box">
							<a href=""> <i class="fa fa-map-marker" aria-hidden="true"></i>
								<span> Gb road 123 london Uk </span>
							</a> <a href=""> <i class="fa fa-phone" aria-hidden="true"></i> <span>+01
									12345678901</span>
							</a> <a href=""> <i class="fa fa-envelope" aria-hidden="true"></i>
								<span> demo@gmail.com</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- footer section -->
		<footer class=" footer_section">
			<div class="container">
				<p>
					&copy; <span id="displayYear"></span> All Rights Reserved By <a
						href="https://html.design/">Free Html Templates</a>
				</p>
			</div>
		</footer>
		<!-- footer section -->

	</section>

	<!-- end info section -->


	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
		
	</script>
	<script src="js/custom.js"></script>

</body>

</html>