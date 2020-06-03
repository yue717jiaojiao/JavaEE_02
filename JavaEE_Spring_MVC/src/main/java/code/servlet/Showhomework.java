package code.servlet;

/*
import code.jdbc.StudentHomeworkJdbc;
import code.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/submitted_homework")

public class Showhomework extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        //按指定id查找学生作业
        List<StudentHomework> list = null;
        try {
            list = StudentHomeworkJdbc.selectStudentHomeworkbyid(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("list",list);
        req.getRequestDispatcher("function/Check_situation.jsp").forward(req,resp);
    }
}
*/
