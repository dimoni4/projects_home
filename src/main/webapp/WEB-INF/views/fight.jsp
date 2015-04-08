<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>User</h1>

	<h2>${user.name}</h2>
	<h2>${user.hitpoints}</h2>
	<h2>${user.power}</h2>
	<h2>Search fight: ${user.fightStatus}</h2>

	<h1>Enemy</h1>

	<h2>${enemy.name}</h2>
	<h2>${enemy.hitpoints}</h2>
	<h2>${enemy.power}</h2>
	<h2>Search fight: ${user.fightStatus}</h2>


	<div id="container">
		<form action="<c:url value="/fight/search"/>" method="POST">
			<button type="submit" class="btn btn-default">Поиск боя</button>
		</form>
	</div>

</body>
</html>