package code.servlet;


/*import code.jdbc.StudentHomeworkJdbc;
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
//提交作业
@WebServlet("/Add_student_homework")
public class AddStudentHomeworkServlet extends HttpServlet {

    @Override
    //选取所有已布置作业
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Homework> list = null;
        try {
            list = StudentHomeworkJdbc.selectAllhw();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("list", list);

        req.getRequestDispatcher("function/Add_student_homework_1.jsp").forward(req, resp);
    }

}*/
