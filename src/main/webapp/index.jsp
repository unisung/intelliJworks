<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<%-- HTML Hyper Text Markup Language--%>
<a href="hello-servlet">Hello Servlet</a><%-- http://localhost:8181 + / + hello-servlet--%>
<h1>Hello Servlet</h1><%-- HTML 표현방식--%>
<h1><%="Hello world!"%></h1><%-- expression태그로 문자열을 출력 --%>
<h1>${"hello world!"}</h1><%-- EL로 문자열 출력 --%>
</body>
</html>