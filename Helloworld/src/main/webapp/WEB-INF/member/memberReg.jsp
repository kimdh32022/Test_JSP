<%--
  Created by IntelliJ IDEA.
  User: kimdh
  Date: 24. 11. 26.
  Time: 오후 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Member 등록 폼</h1>
<form action="/member/register" method="post">
    <div>
        <input type="text" name = "ID" placeholder="아이디를 입력해주세요.">
    </div>
    <div>
        <input type="text" name = "Password" placeholder="비밀번호를 입력해주세요">
    </div>
    <div>
        <input type="text" name = "Uname" placeholder="이름을 입력해주세요">
    </div>
    <button type="reset">초기화</button>
    <button type="submit">등록</button>
</form>
</body>
</html>
