<%--
  Created by IntelliJ IDEA.
  User: kimdh
  Date: 24. 11. 22.
  Time: 오후 5:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BlogTest</title>
</head>
<body>
<%--action은 서버에 전달할 경로, method 형식으로 --%>
<form action="http://localhost:8080/test1" method="get">
    <input type="text" name="name" placeholder="Name"/>
    <input type="text" name="email" placeholder="Email"/>
    <input type="submit"/>
</form>
</body>
</html>
