package code.servlet;

import code.jdbc.StudentHomeworkJdbc;
import code.model.Homework;
import code.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/submit_homework")
public class Submithomework extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        //读取指定id的作业内容详细信息
        Homework homework = null;
        try {
            homework = StudentHomeworkJdbc.selectHomeworkbyid(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("homework",homework);
        req.getRequestDispatcher("function/Add_student_homework.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        StudentHomework studentHomework = new StudentHomework();

        studentHomework.setStudentId(Long.parseLong(req.getParameter("studentId")));
        studentHomework.setHomeworkId(Long.parseLong(req.getParameter("homeworkId")));
        studentHomework.setHomeworkTitle(req.getParameter("title"));
        studentHomework.setHomeworkContent(req.getParameter("content"));
        studentHomework.setstudentAnswer(req.getParameter("student_answer"));
        Date date = new Date();
        studentHomework.setCreateTime(date);

        boolean result = false;
        try {
            result = StudentHomeworkJdbc.addStudentHomework(studentHomework);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //判断是否提交作业成功
        req.setAttribute("judge", result);
        req.setAttribute("type","addStudentHomework");
        req.getRequestDispatcher("function/judge.jsp").forward(req,resp);
    }
}
