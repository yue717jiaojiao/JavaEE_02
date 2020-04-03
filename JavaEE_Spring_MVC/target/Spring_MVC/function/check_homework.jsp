<%@ page import="com.java.code.model.Homework" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020-03-11
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>已布置作业</title>

    <script>
        function jump(id) {
            let homework = document.getElementById('homeworkId')
            homework.setAttribute("value",id)
            let choose = document.getElementById('choose')
            choose.submit()
        }
    </script>

</head>
<body>
<div align="center">
<h2>已布置作业</h2>

<form id="choose" method="get" action="${pageContext.request.contextPath}/submitted_homework">

    <input id="homeworkId" name="id" type="hidden">

    <table align="center" width="960" border="1"
           cellpadding="1" cellspacing="1">

        <tr align="center" bgcolor="#7fffd4" height="50">
            <th width="5%">作业编号</th>
            <th width="20%">作业题目</th>
            <th width="65">作业内容</th>
            <th width="10%">已提交作业</th>
        </tr>

        <%
            List<Homework> list = (List<Homework>)request.getAttribute("homework");
            if (list == null || list.size() <= 0){
               out.print("None data");
            }else {
                for (Homework homework : list) {
        %>
        <tr align="center" bgcolor="white" height="30">
            <td><%=homework.getId()%></td>
            <td><%=homework.getTitle()%></td>
            <td><%=homework.getContent()%></td>
            <td><input type="button" value="已提交作业" onclick="jump(<%=homework.getId()%>)"> </td>
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
