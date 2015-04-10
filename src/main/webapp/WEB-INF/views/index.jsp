<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<form action="<c:url value="/j_spring_security_logout"/>" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<button type="submit" class="btn btn-default">Выйти</button>
</form>

	<h1>Index page</h1>

	<h2>${user.name}</h2>
	<h2>${user.hitpoints}</h2>
	<h2>${user.power}</h2>
	<h2>Search fight: ${user.fightStatus}</h2>


	<div id="container">
		<form action="<c:url value="/fight/search"/>" method="POST">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<button type="submit" class="btn btn-default">Поиск боя</button>
		</form>
	</div>

</body>
</html>