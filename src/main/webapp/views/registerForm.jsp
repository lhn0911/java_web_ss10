<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/16/2025
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Nhập thông tin đăng kí</h2>

<form action="register" method="post">
    <table>
        <tr>
            <td>Tên đăng nhập:</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>Mật khẩu:</td>
            <td><input type="number" name="password"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="email"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>
