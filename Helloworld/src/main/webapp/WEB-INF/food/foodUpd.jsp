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
<h1>Food, 미니실습 fno 번호로 하나 조회하는 화면, 상세보기와 같은 역할. </h1>
<form action="/food/update?tno=${dto.tno}" method="post">
    <div>
        <input type="text" name="tno" value="${dto.tno}" readonly>
    </div>
    <div>
        <input type="text" name="title" value="${dto.title}" placeholder="제목을 입력 해주세요.">
    </div>
    <div>
        <input type="date" name="dueDate" value="${dto.dueDate}">
    </div>
    <div>
        <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""} >
    </div>
    <div>
        <button type="submit">수정하기</button>
    </div>
</form>
<form action="/food/delete?tno=${dto.tno}" method="post">
    <button type="submit">삭제</button>

    <a href="/food/list">목록으로</a>
</form>
</body>
</html>
