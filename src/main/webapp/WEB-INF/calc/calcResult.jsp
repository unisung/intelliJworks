<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022-11-28
  Time: 오후 2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>calcResult.jsp</h1>
<p><%=request.getAttribute("num1")%></p>
<p><%=request.getAttribute("num2")%></p>
${num1}<br>
${num2}<br>
<b>${param.num1},${param.num2}</b>
</body>
</html>
