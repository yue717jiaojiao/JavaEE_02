<%@ page import="com.java.code.model.Homework" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020-03-09
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交作业列表</title>
    <%--    将指定的作业id传给/submit,以便提交作业--%>

    <script>
        function jump(id) {
            let homework = document.getElementById('homeworkId')
            homework.setAttribute("value",id)
            let sub = document.getElementById('sub')
            sub.submit()
        }
    </script>
</head>
<body>
<div align="center">
<h2>已布置作业</h2>

<form id="sub" method="get" action="${pageContext.request.contextPath}/submit_homework">

    <input id="homeworkId" name="id" type="hidden">

    <table align="center" width="960" border="1" cellpadding="1" cellspacing="1">
        <tr align="center" bgcolor="#7fffd4" height="50">
            <th>作业编号</th>
            <th>作业题目</th>
            <th>作业内容</th>
            <th>提交作业</th>
        </tr>

        <%
            List<Homework> list = (List<Homework>)request.getAttribute("list");
            if (list == null || list.size() <= 0){
//                out.print("None data");
            }else {
                for (Homework homework : list) {
        %>
        <tr>
            <td width="5%"><%=homework.getId()%></td>
            <td width="20%" style="word-break: break-all;word-wrap: break-word"><%=homework.getTitle()%></td>
            <td width="65%" style="word-break: break-all;word-wrap: break-word"><%=homework.getContent()%></td>
            <td width="10%"><input type="button" value="提交作业" onclick="jump(<%=homework.getId()%>)"> </td>
        </tr>

        <%
                }
            }
        %>

    </table>
</form>
</div>
</body>
</html>
