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
	<!-- header section starts -->
	<jsp:include page="/header-section.jsp" />
	<!-- end header section -->

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
				<form action="Register" method="post" class="registerForm">
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
				<span>Already had an account? Log in <a href="login.jsp">here</a></span>
			</div>
		</div>
	</section>

	<!-- end register section -->

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