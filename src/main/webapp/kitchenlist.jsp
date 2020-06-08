<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.group6.pro.model.Kitchens" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	        <h1>Registered Kitchen List</h1>
<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>kitchenId</th>
			<th>kitchen_name</th>
			<th>kitchen_working_days</th>
			<th>Kitchen_start_time</th>
			<th>Kitchen_stop_time</th>
		</tr>
		<c:forEach var="kitchens" items="${KitchenList }">
			<tr>
				<td>${kitchens.kitchenid }</td>
				<td>${kitchens.kitchenName  }</td>
				<td>${kitchens.kitchen_working_Days  }</td>
				<td>${kitchens.kitchen_start_time  }</td>
				<td>${kitchens.kitchen_stop_time  }</td>
				</td>
			</tr>
		</c:forEach>
	</table> 

</body>
</html>