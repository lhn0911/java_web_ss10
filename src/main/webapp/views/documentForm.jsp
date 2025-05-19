<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/19/2025
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Upload Tài Liệu PDF</h2>
<form:form method="post" modelAttribute="document" enctype="multipart/form-data" action="/upload">
    <table>
        <tr>
            <td>Tiêu đề:</td>
            <td><form:input path="title" /></td>
        </tr>
        <tr>
            <td>Mô tả:</td>
            <td><form:textarea path="description" /></td>
        </tr>
        <tr>
            <td>Chọn file:</td>
            <td><form:input path="file" type="file" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Upload" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
