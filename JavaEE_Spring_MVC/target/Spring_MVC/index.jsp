<%@ page import="code.model.StudentHomework" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: wkm
  Date: 2020/2/27
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎使用本系统！</title>
</head>
<body>

<div align="center">
    <h2>请选择您的身份:</h2>
    <h2>${pageContext.request.contextPath}</h2>
    <ul>
        <a href="function/Studentpart.jsp">学生</a>
        <a href="function/teacherpart.jsp">老师</a>

    </ul>
</div>

</body>
</html>
