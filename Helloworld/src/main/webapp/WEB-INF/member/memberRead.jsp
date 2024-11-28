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
    <input type="text" name="uno" value="${dto.uno()}" readonly>
</div>
<div>
    <input type="text" name="id" value="${dto.id()}" placeholder="아이디" readonly>
</div>
<div>
    <input type="text" name="password" value="${dto.password()}"readonly>
</div>
<div>
    <input type="text" name="uname" value= "${dto.uname()}" readonly>
</div>
<div>
    <a href="/member/update?uno=${dto.uno()}">수정하기</a>
    <a href="/member/list">목록으로</a>
</div>
</body>
</html>
