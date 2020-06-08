<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
         <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/bootstrap-grid.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/bootstrap-grid.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/bootstrap-reboot.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/bootstrap-reboot.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
      
      <style>

		.topright {
  		position: absolute;
  		top: 8px;
  		right: 16px;
  		font-size: 18px;
		}

		</style>
</head>
<body>
  <div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h4>Welcome to FeastFreedom ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h4>
    </c:if>
  </div>
  
    
        <div class="container">
      <form method="POST" action="${contextPath}/login" class="form-signin">


        <div class="form-group ${error != null ? 'has-error' : ''}">
        	<a href="${contextPath}/kitchenlist" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Please select your kitchen!</a>


        </div>
      </form>
    </div>
    
            <div class="container">
      <form method="POST" action="${contextPath}/login" class="form-signin">


        <div class="form-group ${error != null ? 'has-error' : ''}">
			<a href="${contextPath}/addKitchen" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Provider register now</a>

        </div>
      </form>
    </div>
    

            <button  type="button" class="btn btn-link" > 
  				<span class="glyphicon glyphicon-shopping-cart" style="font-size:40px" <a href="${contextPath}/kitchenlist">Shopping Cart</a>>
  				</span>
  				
			</button>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
