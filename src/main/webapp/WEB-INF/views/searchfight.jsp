<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Searching for fight</h1>

	<div id="container">
			<form action="<c:url value="/fight/search/stop"/>" method="POST">
				<button type="submit" class="btn btn-default">Отменить поиск боя</button>
			</form>
	</div>

</body>
</html>