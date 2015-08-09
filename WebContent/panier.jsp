<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="p"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/site.css">
<style>
a {
	text-decoration: none;
}

th, td {
	text-align: center;
	width: 75px;
}
</style>
<title>Mes voyages</title>
</head>
<body>
	<div id="page">
		<div id="main">
			<h1>Votre panier</h1>
			<c:choose>
				<c:when test="${empty panier.voyages }">
					<h2>...est vide...</h2>
				</c:when>

				<c:otherwise>
					<table id="details_table">
						<tr>
							<th>Destination</th>
							<th>Départ</th>
							<th>Retour</th>
							<th>Prix</th>
							<th>Places</th>
							<th>Prix total</th>
							<th></th>
							<th>Supprimer</th>
						</tr>
						<c:set var="prix" value="${0 }" />
						<c:forEach items="${panier.voyages }" var="voyage"
							varStatus="status">
							<tr>
								<fmt:setLocale value="fr_FR" />
								<td><b><c:out value="${voyage.region }"></c:out></b></td>
								<td><fmt:formatDate type="date"
										value="${voyage.datesVoyage.dateDepart }" dateStyle="short" /></td>
								<td><fmt:formatDate type="date"
										value="${voyage.datesVoyage.dateRetour }" dateStyle="short" /></td>
								<td><fmt:formatNumber value="${voyage.datesVoyage.prixHT }"
										type="currency" /></td>
								<td><c:out value="${voyage.nbPlaces }" />
								<td><fmt:formatNumber
										value="${voyage.datesVoyage.prixHT*voyage.nbPlaces }"
										type="currency" /> <c:set var="prix"
										value="${prix+voyage.datesVoyage.prixHT*voyage.nbPlaces }" />
								<td><a
									href="panier.jsp?inscr=ok&places=${voyage.nbPlaces }">Valider
										les places</a></td>
								<td><a
									href="FrontControllerServlet?cde=rem&indexVoy=${status.index }">Supprimer</a></td>
							</tr>
						</c:forEach>
					</table>

					<h3>
						<c:out value="Prix total de la commande : " />
						<fmt:formatNumber value="${prix }" type="currency" />
					</h3>
				</c:otherwise>
			</c:choose>

			<br />
			<c:if test="${not empty param.inscr }">
				<jsp:include page="fragments/form_inscr.jsp">
					<jsp:param value="${param.places }" name="places" />
				</jsp:include>
			</c:if>

			<br />
			<p:to_home />
		</div>
	</div>
</body>
</html>