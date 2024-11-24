<%--
  Created by IntelliJ IDEA.
  User: kimdh
  Date: 24. 11. 24.
  Time: 오후 4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>My Blog</h1>
<h2>Wellcom my Blog</h2>
<button><a href="/blog/login">로그인 하기</a></button>
<h2>더미 데이터 단순 출력</h2>
${list}
<br>
<h3>리스트의 인덱스 0번만 출력</h3>
${list[0]}
<br>
<h3>리스트의 인덱스 1번의 title만 출력</h3>
${list[1].title}
</body>
</html>
