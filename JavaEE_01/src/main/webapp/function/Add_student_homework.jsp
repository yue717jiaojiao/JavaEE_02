<%@ page import="com.java.code.model.StudentHomework" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.code.jdbc.StudentHomeworkJdbc" %>
<%@ page import="com.java.code.model.Homework" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020-03-09
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交作业(学生)</title>
</head>
<body>
<div align="center">
    <h2>提交作业</h2>
    <form method="post" action="${pageContext.request.contextPath}/submit_homework">
        <table align="center"  border="1" width="960" cellpadding="1" cellspacing="1">
            <%
                Homework homework = (Homework) request.getAttribute("homework");

            %>
            <tr>
                <th width="10%" bgcolor="#7fffd4">作业题目:</th>
                <td width="90%"><%=homework.getTitle()%></td>
            </tr>
            <tr>
                <th width="10%" bgcolor="#7fffd4">作业内容:</th>
                <td width="90%"><%=homework.getContent()%></td>
            </tr>
            <tr>
                <th width="10%" bgcolor="#7fffd4">学号:</th>
                <td width="90%"><input type="number" name="studentId"
                                       maxlength="20" style="font-family: Arial;  width: 100%" required>
                </td>
            </tr>
            <input type="hidden" name="title" value="<%=homework.getTitle()%>">
            <input type="hidden" name="homeworkId" value="<%=homework.getId()%>">
            <input type="hidden" name="content" value="<%=homework.getContent()%>">
            <tr>
                <th width="10%" bgcolor="#7fffd4">答案内容</th>
                <td width="90%"><textarea rows="10" name="student_answer"  style="width: 100%" onpropertychange="if(this.scrollHeight>10) this.style.posHeight=this.scrollHeight+5"
                                          required></textarea></td>
            </tr>
            <tr style="border: none">
                <td align="center"><input type="reset" value="清空"></td>
                <td align="center"><input type="submit" value="提交"></td>
            </tr>
        </table>


    </form>
</div>
</body>
</html>
