<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link href="<c:url value="/resources/css/dash.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/foundation-icons/foundation-icons.css"/>" rel="stylesheet">
</head>

<body>

<form action="<c:url value="/logout"/>" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<button type="submit" class="btn btn-default">Выйти</button>
</form>

<menu id="menuLeft">
	<ul class="ulxL">
		<li class="li-main">
			<div class="menu-icon">
				<span class="hamburger"></span>
				<span class="hamburger"></span>
				<span class="hamburger"></span>
			</div>
		</li>
		<li class="li-main">
			<div class="menu-item">
				<a href="#" id="dashboard">
					<i class="icon fi-graph-pie" id="i-dash"></i>
				</a>
			</div>
		</li>
		<li class="li-main">
			<div class="menu-item">
				<a href="#" id="projects">
					<i class="icon fi-paypal" id="i-projects"></i>
				</a>
			</div>
		</li>
		<li class="li-main">
			<div class="menu-item ">
				<a href="#" id="settings">
					<i class="icon fi-wrench" id="i-settings"></i>
				</a>
			</div>
		</li>
	</ul>
</menu>
<header id="top">
	<span id="header">Welcome!</span>
</header>
<section id="content">
	Check category in menu!
</section>



</body>
<link href="<c:url value="/resources/js/main.js.txt"/>" rel="script">
<link href="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"/>" rel="script">
</html>

<!--
	<h1>Index page</h1>
	<h2>${user.email}</h2>
</body>
</html>
-->
