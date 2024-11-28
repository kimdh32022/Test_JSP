<%--
  Created by IntelliJ IDEA.
  User: kimdh
  Date: 24. 11. 27.
  Time: 오전 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Member 업데이트 창 </h1>
<form action="/member/update?Uno=${dto.getUno()}" method="post">
    <div>
        <input type="text" name="Uno" value="${dto.getUno()}" readonly>
    </div>
    <div>
        <input type="text" name="ID" value="${dto.getID()}" placeholder="바꾸실 아이디를 입력해주세요.">
    </div>
    <div>
        <input type="text" name="Password" value="${dto.getPassword()}">
    </div>
    <div>
        <input type="text" name="Uname" value="${dto.getUname()}" placeholder="이름을 입력해주세요.">
    </div>
    <div>
        <button type="submit">수정하기</button>
    </div>
</form>
<form action="/member/delete?Uno=${dto.getUno()}" method="post">
    <button type="submit">삭제</button>

    <button a href="/member/list">돌아가기</button>
</form>
</body>
</html>
