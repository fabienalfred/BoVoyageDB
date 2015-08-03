<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="p"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mes voyages</title>
</head>
<body>

	<h1>Votre panier</h1>
	
	<table style="width:50%" border="1" >
		<tr>
			<th colspan="3">Voyages</th>
			<th>Supprimer</th>
		</tr>
		<c:forEach items="${sessionScope.panier.voyages }" var="voyage">
		<tr><fmt:setLocale value="fr_FR"/>
			<td><fmt:formatDate type="date" value="${voyage.dateDepart }" dateStyle="long"/></td>
			<td><fmt:formatDate type="date" value="${voyage.dateRetour }" dateStyle="long"/></td>
			<td><fmt:setLocale value="fr_FR"/><fmt:formatNumber value="${voyage.prixHT }" type="currency"/></td>
			<td><a href="PanierServlet?action=remove&idVoy=${voyage.idDateVoyage }">Supprimer</a></td>
		</tr>
		</c:forEach>
	</table>
	<br />

	<p:accueil />	

</body>
</html>