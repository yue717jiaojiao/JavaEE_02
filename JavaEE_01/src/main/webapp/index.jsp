<%@ page import="com.java.code.model.StudentHomework" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.code.jdbc.StudentHomeworkJdbc" %>

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
    <h2>请选择你要进行的操作:</h2>
    <h2>${pageContext.request.contextPath}</h2>
    <ul>
        <a href="function/Add_student.jsp">添加学生</a>
        <a href="function/Add_homework.jsp">布置作业</a>

        <a href="${pageContext.request.contextPath}/Add_student_homework">提交作业</a>
        <a href="${pageContext.request.contextPath}/show_homework">查询情况</a>
</ul>
</div>

</body>
</html>
