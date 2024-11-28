<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 21.
  Time: 오전 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--JSTL 사용하기 준비 단계--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Member 목록화면. </h1>
<a href="/member/register">글쓰기 폼이동</a>
<h2>FoodRead 하나 조회 더미 </h2>
<a href="/member/read?Uno=5">하나 조회</a>

<h2>JSTL 연습장</h2>
<ul>
  <c:forEach var="dto" items="${list}">
    <li>
      <span>${dto.getUno()}</span>
      <span><a href="/member/read?Uno=${dto.getUno()}">${dto.getID()}</a></span>
      <span>${dto.getPassword()}</span>
      <span>${dto.getUname()}</span>
    </li>
  </c:forEach>
</ul>


</body>
</html>
