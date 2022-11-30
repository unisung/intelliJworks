<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022-11-29
  Time: 오전 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<ul>
  <li>
    <c:forEach var="dto" items="${list}">
        <li>
          <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
          <span>${dto.title}</span>
          <span>${dto.dueDate}</span>
          <span>${dto.finished?"DONE" :"NOT YET"}</span>
        </li>
    </c:forEach>
  </li>
</ul>

</body>
</html>
