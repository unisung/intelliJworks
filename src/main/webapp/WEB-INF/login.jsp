<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022-11-30
  Time: 오전 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>${param.result}</div>
 <form action="/login" method="post">
     <input name="mid">
     <input name="mpw">
     <button type="submit">LoGIN</button><br>
     <label><input type="checkbox" name="auto"> remember-Me</label>
 </form>
</body>
</html>
