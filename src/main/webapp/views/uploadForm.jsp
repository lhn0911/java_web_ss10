<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/16/2025
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Upload ảnh đại diện</h2>
<form:form method="post" action="/upload-avatar" modelAttribute="userProfile" enctype="multipart/form-data">
    <table>
        <tr>
            <td>Username:</td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td>Avatar:</td>
            <td><form:input path="avatar" type="file"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Upload"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
