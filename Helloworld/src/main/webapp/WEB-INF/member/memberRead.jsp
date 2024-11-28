<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 21.
  Time: 오후 4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Member, 미니실습 Uno 번호로 하나 조회하는 화면, 상세보기와 같은 역할. </h1>
<div>
    <input type="text" name="Uno" value="${dto.getUno()}" readonly>
</div>
<div>
    <input type="text" name="ID" value="${dto.getID()}" placeholder="아이디" readonly>
</div>
<div>
    <input type="text" name="Password" value="${dto.getPassword()}"readonly>
</div>
<div>
    <input type="text" name="Uname" value= "${dto.getUname()}" readonly>
</div>
<div>
    <a href="/member/update?Uno=${dto.getUno()}">수정하기</a>
    <a href="/member/list">목록으로</a>
</div>
</body>
</html>
