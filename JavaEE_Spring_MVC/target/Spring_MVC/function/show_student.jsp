<%@ page import="com.java.code.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.code.jdbc.StudentHomeworkJdbc" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020-03-12
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h2>已添加学生</h2>

    <table align="center" width="960" border="1"
           cellpadding="1" cellspacing="1">
        <tr align="center" bgcolor="#7fffd4" height="50">

            <td>学生学号</td>
            <td>学生姓名</td>
            <td>创建时间</td>
        </tr>
        <%
            List<Student> list = StudentHomeworkJdbc.selectAllstudent();
            if(null == list || list.size() <= 0){
                out.print("None data.");
            }else {
                for (Student sh : list){
        %>
        <tr align="center" bgcolor="white" height="30">

            <td><%=sh.getId()%></td>
            <td><%=sh.getName()%></td>
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
