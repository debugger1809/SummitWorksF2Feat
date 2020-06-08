<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create an account</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

        <form:form method="POST" modelAttribute="kitchens" class="form-signin">
            <h2 class="form-signin-heading">Please enter your restaurant information</h2>
            <spring:bind path="kitchenid">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="kitchenid" class="form-control" placeholder="Kitchen Id"
                                autofocus="true"></form:input>
                    <form:errors path="kitchenid"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="kitchenName">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="kitchenName" class="form-control" placeholder="Kitchen Name"
                                autofocus="true"></form:input>
                    <form:errors path="kitchenName"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="Kitchen_working_Days">
                <%-- <div class="form-group ${status.error ? 'has-error' : ''}"> --%>
                    <form:input type="date" path="Kitchen_working_Days" class="form-control" placeholder="Kitchen Working Days"></form:input>
                    <form:errors path="Kitchen_working_Days"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="Kitchen_start_time">
                <%-- <div class="form-group ${status.error ? 'has-error' : ''}"> --%>
                    <form:input type="text" path="Kitchen_start_time" class="form-control"
                                placeholder="Kitchen_start_time"></form:input>
                    <form:errors path="Kitchen_start_time"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="Kitchen_stop_time">
               <%--  <div class="form-group ${status.error ? 'has-error' : ''}"> --%>
                    <form:input type="text" path="Kitchen_stop_time" class="form-control"
                                placeholder="Kitchen_stop_time"></form:input>
                    <form:errors path="Kitchen_stop_time"></form:errors>
                </div>
            </spring:bind>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
        </form:form>

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
