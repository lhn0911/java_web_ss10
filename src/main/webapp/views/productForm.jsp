<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/16/2025
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Nhập thông tin sản phẩm</h2>

<form action="add" method="post">
    <table>
        <tr>
            <td>Tên sản phẩm:</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Giá:</td>
            <td><input type="number" name="price"/></td>
        </tr>
        <tr>
            <td>Mô tả:</td>
            <td><input type="text" name="description"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>
