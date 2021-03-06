<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="p"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
a{
	text-decoration: none;
}
</style>
<title>Nos offres de voyage</title>
</head>
<body>

	<h1>Nos destinations</h1>
	<c:if test="${destinations != null }">
		<c:forEach items="${destinations }" var="d">
			<h2>
				<a href="DestinationServlet?idDest=${d.idDest }"
					style="text-decoration: none"><c:out value="${d.region }"></c:out></a>
			</h2>
			<img alt="${d.images[0] }" src="images/${d.images[0] }">
		</c:forEach>
	</c:if>

	<p:to_panier />
	
</body>
</html>