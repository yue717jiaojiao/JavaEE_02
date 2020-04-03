<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020-03-11
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>操作判断</title>
</head>
<body>
<div align="center">
<%
    String type = (String)request.getAttribute("type");
    boolean judge = (boolean)request.getAttribute("judge");

    if (judge){
        if (type.equals("addHomework")){%>

<p align="center" style="font-size: 1.1em; color: cornflowerblue"><%="添加作业成功!"%></p>
    <a align="center" href="index.jsp">返回首页</a>

<%}else if (type.equals("addStudent")){%>

<p align="center" style="font-size: 1.1em; color: cornflowerblue"><%="添加学生成功!"%></p>
    <a align="center" href="index.jsp">返回首页</a>
    <a align="center" href="function/show_student.jsp">查看已添加学生</a>

<%} else if (type.equals("addStudentHomework")){%>

<p align="center" style="font-size: 1.1em; color: cornflowerblue"><%="作业提交成功!"%></p>
    <a align="center" href="index.jsp">返回首页</a>

<%} else{ %>

<p align="center" style="font-size: 1.1em; color: darkred"><%="操作失败!"%></p>
    <a align="center" href="index.jsp">返回首页</a>

<%
}
    }
%>

</div>
</body>
</html>
