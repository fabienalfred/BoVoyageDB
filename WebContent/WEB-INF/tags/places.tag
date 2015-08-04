<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c" %>
<select name="nbPlaces">
	<c:forEach begin="1" end="10" var="index">
		<option value="${index }">${index }</option>
	</c:forEach>
</select>