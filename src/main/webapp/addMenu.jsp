<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Add Menu</title>
    <meta charset="UTF-8">
</head>
<body>

<h1>Add a Product to ${kitchen.kitchenName}</h1>

<form class="form-signin" action="/addMenu" method="post">
    <p>
        Name: <input type="text" name="name" id="name">
    </p>
    <p>
        Image: <input type="text" name="photo" id="photo">
    </p>
    <p>
        Price: <input type="text" name="price" id="price">
    </p>
    <p>
        <input type="submit" value="Submit"/> <input type="reset" value="Reset">
    </p>
</form>

<a href="/welcome.jsp">Done Adding Products</a>

</body>
</html>