
package code.servlet;

/*
import code.jdbc.StudentHomeworkJdbc;
import code.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/Add_student")
public class AddStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Student student = new Student();
        student.setId(Long.parseLong(req.getParameter("sid")));
        student.setSname(req.getParameter("sname"));
        Date date = new Date();
        student.setCreateTime(date);

        boolean result = false;
        try {
            result = StudentHomeworkJdbc.addStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //判断是否添加学生成功
        req.setAttribute("judge", result);
        req.setAttribute("type","addStudent");
        req.getRequestDispatcher("function/judge.jsp").forward(req,resp);

    }


}
*/
