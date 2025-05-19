<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/16/2025
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset=UTF-8">
    <title>Form Nhập Thông Tin Cá Nhân</title>
</head>
<body>
<h2>Nhập thông tin cá nhân</h2>

<form action="submit" method="post">
    <table>
        <tr>
            <td>Tên:</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Tuổi:</td>
            <td><input type="number" name="age"/></td>
        </tr>
        <tr>
            <td>Địa chỉ:</td>
            <td><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"/></td>
        </tr>
    </table>
</form>

</body>
</html>

