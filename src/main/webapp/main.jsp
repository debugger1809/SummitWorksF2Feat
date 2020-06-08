<%@ page import="com.group6.pro.service.KitchenServiceImpl" %>
<%@ page import="com.group6.pro.model.Kitchens" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
  	<title>Kitchen Menu</title>
  </head>
  <body>
  	Kitchen Menu
  	<% Kitchens kitchen =  (new KitchenServiceImpl()).findById(2);
  		kitchen.toString();
  	%>
  </body>
</html>