package code.servlet;


/*
import code.jdbc.StudentHomeworkJdbc;
import code.model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

*/
/*

//显示作业完成情况
@WebServlet("/show_homework")
public class StudentHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查找所有已布置作业
        List<Homework> list = null;
        try {
            list = StudentHomeworkJdbc.selectAllhw();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("homework", list);

        req.getRequestDispatcher("function/check_homework.jsp").forward(req, resp);
    }
}
*/
