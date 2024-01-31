<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<div class="hero_area">
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
						<input hidden="true" value="SEARCH" name="action"> <input
							type="text" name="searchField" placeholder="Search for product" />
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
					<c:forEach items="${categoryList}" var="category">
						<li class="nav-item"><a class="nav-link"
							href="Home?action=SHOW_PRODUCT_BY_CATEGORY&categoryId=${category.id}">
								${category.name} </a></li>
					</c:forEach>
				</ul>
				<div class="user_option">
					<c:if test="${empty sessionScope.user}">
						<a href="login.jsp"> <i class="fa fa-user" aria-hidden="true"></i>
							<span>Login</span>
						</a>
					</c:if>
					<c:if test="${not empty sessionScope.user}">
						<span>Welcome, ${user.firstName}!</span>
						<a href="Authentication?action=LOGOUT"> <i class="fa fa-user"
							aria-hidden="true"></i> <span>Logout</span>
						</a>
					</c:if>
					<a href="Cart?action=VIEW_CART"> <i class="fa fa-shopping-bag"
						aria-hidden="true"></i> (${sessionScope.cart.items.size()})
					</a>
				</div>
			</div>
		</nav>
	</header>
</div>
</html>
