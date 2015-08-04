<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<fieldset style="width: 600px">
	<legend>Inscription</legend>
	<form action="panier.jsp" method="post">
		<c:forEach begin="1" end="${param.places }" var="index">
		Nom : <input name="nom${index }" />
		Prénom : <input name="prenom${index }" />
		Age : <input name="age${index }" style="width: 25px"/>
		<br />
		</c:forEach>
		<button>Valider</button>
	</form>
</fieldset>

</body>
</html>