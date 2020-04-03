<%@ page import="com.java.code.jdbc.StudentHomeworkJdbc" %>
<%@ page import="com.java.code.model.StudentHomework" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020-03-09
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业情况</title>
</head>
<body>
<div align="center">
<h2>该题目已提交作业</h2>

<table align="center" width="960" border="1"
       cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fffd4" height="50">

        <td>学生学号</td>
        <td>作业编号</td>
        <td>作业题目</td>
        <td>作业内容</td>
        <td>学生答案</td>
        <td>创建时间</td>
    </tr>
    <%
        List<StudentHomework> list = (List<StudentHomework>)request.getAttribute("list");
        if(null == list || list.size() <= 0){
            out.print("None data.");
        }else {
            for (StudentHomework sh : list){
    %>
    <tr align="center" bgcolor="white" height="30">

        <td><%=sh.getStudentId()%></td>
        <td><%=sh.getHomeworkId()%></td>
        <td><%=sh.getHomeworkTitle()%></td>
        <td><%=sh.getHomeworkContent()%></td>
        <td><%=sh.getStudentAnswer()%></td>
        <td><%=sh.getCreateTime()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
</div>
</body>
</html>
