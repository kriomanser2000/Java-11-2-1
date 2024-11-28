<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="addSeller" method="post">
    <label for="sellerName">Name:</label>
    <input type="text" id="sellerName" name="sellerName" required><br>
    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone" required><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br>
    <button type="submit">Add Seller</button>
</form>
</body>
</html>