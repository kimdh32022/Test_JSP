<%--
  Created by IntelliJ IDEA.
  User: kimdh
  Date: 24. 11. 27.
  Time: 오후 3:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>LogIn Page</h1>
<c:if test="${param.result == 'error'}">
    <h1>로그인 정보 확인 후 다시 로그인 해주세요.</h1>
</c:if>
<form action="/login" method="post">
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="password" placeholder="Password">
    <button type="submit">로그인</button>
</form>
</body>
</html>
