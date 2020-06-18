<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020-06-16
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎你</title>
</head>
<body>
<div align="center">
    <h2>请操作:</h2>
    <h2>${pageContext.request.contextPath}</h2>
    <ul>
        <a href="${pageContext.request.contextPath}/Add_student_homework">提交作业</a>

    </ul>

</div>
</body>
</html>
