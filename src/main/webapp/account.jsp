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
				<a class="navbar-brand" href="Home"> <span> Giftos </span>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class=""></span>
				</button>

				<!-- search bar -->
				<div class="searchBar">
					<form action="Home" method="get" class="searchForm">
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
						<li class="nav-item"><a class="nav-link" href="Home">Home</a></li>
					</ul>
					<div class="user_option">
						<a href="account.jsp"> <i class="fa fa-user"
							aria-hidden="true"></i> <span> Login </span>
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
	<section class="shop_section layout_padding" id="login">
		<div class="container">
			<div class="heading_container heading_center">
				<h2>Login to your account</h2>
			</div>
			<c:if test="${not empty loginErrorMessage}">
				<p style="color: red;">${loginErrorMessage}</p>
			</c:if>
			<div>
				<form action="Account?action=LOGIN" method="post" class="loginForm">
					<div class="form-group">
						<label for="userName">Username:</label> <input type="text"
							name="userName" class="form-control" required>
					</div>

					<div class="form-group">
						<label for="userPass">Password:</label> <input type="password"
							name="userPass" class="form-control" required>
					</div>

					<div class="form-group">
						<button class="loginBtn" type="submit">
							<i class="fa fa-user" aria-hidden="true"></i> Login Now
						</button>
					</div>
				</form>
				<span>Don't have an account? <a href="#register">Create
						an account</a></span>
			</div>
		</div>
	</section>
	<!-- end login section -->

	<!-- register section -->
	<section class="shop_section layout_padding" id="register">
		<div class="container">
			<div class="heading_container heading_center">
				<h2>Register a new account</h2>
			</div>
			<c:if test="${not empty registerErrorMessage}">
				<p style="color: red;">${registerErrorMessage}</p>
			</c:if>
			<c:if test="${not empty registerWelcomeMessage}">
				<p style="color: red;">${registerWelcomeMessage}</p>
			</c:if>
			<div>
				<form action="Account?action=REGISTER" method="post"
					class="registerForm">
					<div class="form-group">
						<label for="userFirstName">First Name:</label> <input type="text"
							name="userFirstName" class="form-control" required>
					</div>

					<div class="form-group">
						<label for="userLastName">Last Name:</label> <input type="text"
							name="userLastName" class="form-control" required>
					</div>

					<div class="form-group">
						<label for="userEmail">Email:</label> <input type="email"
							name="userEmail" class="form-control" required>
					</div>

					<div class="form-group">
						<label for="userName">Username:</label> <input type="text"
							name="userName" class="form-control" required>
					</div>

					<div class="form-group">
						<label for="userPass">Password:</label> <input type="password"
							name="userPass" class="form-control" required>
					</div>

					<div class="form-group">
						<button class="registerBtn" type="submit">
							<i class="fa fa-user" aria-hidden="true"></i> Register Now
						</button>
					</div>
				</form>
				<span>Already had an account? Log in <a href="#login">here</a></span>
			</div>
		</div>
	</section>

	<!-- end register section -->
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