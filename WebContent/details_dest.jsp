<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="p"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/site.css">
<link rel="stylesheet"
	href="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.indigo-orange.min.css" />
<script
	src="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>Détails des offres</title>
</head>
<body>
	<div id="page">
		<div id="main">
			<h1>Offres de voyages, destination ${dest.region }</h1>

			<c:forEach items="${dest.images }" var="img">
				<img alt="${img }" src="images/${img }" style="width: 200px">
			</c:forEach>
			<br />

			<h3>${dest.description }</h3>
			<table id="details_table">
				<tr>
					<th>Départ</th>
					<th>Retour</th>
					<th>Prix</th>
					<th>Places</th>
				</tr>
				<c:forEach items="${dest.datesVoyages }" var="dv" varStatus="status">
					<tr>
						<fmt:setLocale value="fr_FR" />
						<td><fmt:formatDate type="date" value="${dv.dateDepart }"
								dateStyle="long" /></td>
						<td><fmt:formatDate type="date" value="${dv.dateRetour }"
								dateStyle="long" /></td>
						<td><fmt:formatNumber value="${dv.prixHT }" type="currency" /></td>
						<td>
							<form
								action="FrontControllerServlet?cde=add&voy=${status.index }&form_inscr=true"
								method="post">
<!-- 								<button -->
<!-- 									class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored"> -->
<!-- 									<i class="material-icons">remove</i> -->
<!-- 								</button> -->
								<p:places />
								<button
									class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored">
									<i class="material-icons">add</i>
								</button>
<!-- 								<button>Ajouter</button> -->
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>

			<br />
			<p:to_panier />
			<br />
			<p:to_home />
		</div>
	</div>
</body>
</html>