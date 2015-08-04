<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="p"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
a{
	text-decoration: none;
}
th, td{
	text-align: center;
	width: 50px;
}
</style>
<title>Détails des offres</title>
</head>
<body>

	<h1>Offres de voyages, destination ${dest.region }</h1>
	
	<c:forEach items="${dest.images }" var="img">
		<img alt="${img }" src="images/${img }" style="width: 200px">
	</c:forEach><br />
	
	<h3>${dest.description }</h3>
	
	<table style="width:50%" border="1" >
		<tr>
			<th>Départ</th>
			<th>Retour</th>
			<th>Prix</th>
			<th>Places</th>
		</tr>
		<c:forEach items="${dest.datesVoyages }" var="dv">
		<tr><fmt:setLocale value="fr_FR"/>
			<td><fmt:formatDate type="date" value="${dv.dateDepart }" dateStyle="long"/></td>
			<td><fmt:formatDate type="date" value="${dv.dateRetour }" dateStyle="long"/></td>
			<td><fmt:formatNumber value="${dv.prixHT }" type="currency"/></td>
			<td>
				<form action="PanierServlet?action=add&idDest=${dest.idDest }&idVoy=${dv.idDateVoyage }&form_inscr=true" method="post">
					<p:places />
					<button>Ajouter</button>	
				</form>
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<br />
	<p:to_panier /><br />
	<p:to_home />

</body>
</html>