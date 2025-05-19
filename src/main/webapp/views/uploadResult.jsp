<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/16/2025
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>${message}</h2>
<p><strong>Username:</strong> ${username}</p>
<c:if test="${not empty avatarPath}">
    <p><img src="${avatarPath}" alt="Avatar" width="200"/></p>
</c:if>
</body>
</html>
