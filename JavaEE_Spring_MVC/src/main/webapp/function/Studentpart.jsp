<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020-06-16
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生登录</title>
</head>
<body>
<div align="center">
    <h2>学生信息</h2>
    <form action="${pageContext.request.contextPath}/student_login" method="post">

        请输入学号:<input type="number" name="id" maxlength="20" style="font-family: arial" required><br/>
        请输入密码:<input type="text" name="password" maxlength="20" style="font-family: arial" required><br/>


        <input type="reset" value="清空">
        <input type="submit" value="确定"><br/>

    </form>
    <ul>
        <a href="studentregister.jsp">学生注册</a>
    </ul>
</div>
</body>
</html>