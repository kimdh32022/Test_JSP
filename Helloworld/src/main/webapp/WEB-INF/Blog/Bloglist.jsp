<%--
  Created by IntelliJ IDEA.
  User: kimdh
  Date: 24. 11. 24.
  Time: 오후 4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>My Blog</h1>
<h2>Wellcom my Blog</h2>
<a href="/blog/login">로그인 하기</a>
<h2>하나 조회</h2>
<a href="/blog/read?Bno=3">조회 하기</a>
<h2>더미 데이터 단순 출력</h2>
${list}
<br>
<h3>리스트의 인덱스 0번만 출력</h3>
${list[0]}
<br>
<h3>리스트의 인덱스 1번의 title만 출력</h3>
${list[1].title}
<h2>jstl연습장</h2>
<h3>반복문, foreach 이용, var 변수명, itmes 데이터 목록</h3>
<ul>
    <c:forEach var="kim" items="${list}">
        <li>${kim}</li>
<%--        kim이란 변수에 list에 넣은 데이터 값들을 하나 씩 넣고 출력함.--%>
    </c:forEach>
</ul>
</body>
</html>
