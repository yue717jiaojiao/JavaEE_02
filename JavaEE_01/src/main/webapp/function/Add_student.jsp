<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020-03-08
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<div align="center">
    <h2>新学生信息</h2>
    <form action="${pageContext.request.contextPath}/Add_student" method="post">
            请输入学号:<input type="number" name="sid" maxlength="20" style="font-family: arial" required><br/>
            请输入姓名:<input type="text" name="sname" maxlength="20" style="font-family: arial" required><br/>


             <input type="reset" value="清空">
             <input type="submit" value="提交"><br/>

    </form>
    <a align="center" href="show_student.jsp">查看已添加学生</a>
</div>
</body>
</html>
