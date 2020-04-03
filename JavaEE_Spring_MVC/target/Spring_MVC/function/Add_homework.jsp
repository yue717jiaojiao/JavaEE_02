<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020-03-09
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>布置作业</title>
</head>
<body>
<div align="center">
<h2>输入新作业相关信息</h2>
    <form action="${pageContext.request.contextPath}/Add_homework" method="post">
        请输入作业id:<input type="number" name="hid" maxlength="20" required><br/>
        请输入作业题目:<input type="text" name="title" maxlength="20" required><br/>

        请输入作业内容:<textarea cols="13" rows="10" name="content" onpropertychange="if(this.scrollHeight>10) this.style.posHeight=this.scrollHeight+5"
                      required>输入内容不得超过140个字</textarea><br/>

        <input type="reset" value="清空">
        <input type="submit" value="提交"><br/>
    </form>
</div>
</body>
</html>
