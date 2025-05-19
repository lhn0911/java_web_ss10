<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/19/2025
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Tạo Dự Án Mới</h2>
<form:form modelAttribute="project" method="post" action="/project/create" enctype="multipart/form-data">
  <table>
    <tr>
      <td>Tên dự án:</td>
      <td><form:input path="name" /></td>
    </tr>
    <tr>
      <td>Mô tả:</td>
      <td><form:textarea path="description" /></td>
    </tr>
    <tr>
      <td>Tài liệu:</td>
      <td><input type="file" name="documents[0].file" multiple /></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="Tạo dự án" /></td>
    </tr>
  </table>
</form:form>
</body>
</html>
