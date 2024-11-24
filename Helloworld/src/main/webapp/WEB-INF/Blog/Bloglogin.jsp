<%--
  Created by IntelliJ IDEA.
  User: kimdh
  Date: 24. 11. 24.
  Time: 오후 4:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인창</title>
</head>
<body>
<form action="/blog/login" method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <button type="submit">전송</button>
</form>
</body>
</html>
