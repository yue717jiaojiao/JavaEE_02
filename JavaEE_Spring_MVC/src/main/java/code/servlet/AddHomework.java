
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
import java.util.Date;

@WebServlet("/Add_homework")
public class AddHomework extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Homework homework = new Homework();
        homework.setId(Long.parseLong(req.getParameter("hid")));
        homework.setTitle(req.getParameter("title"));
        homework.setContent(req.getParameter("content"));
        Date date = new Date();
        homework.setCreateTime(date);

        boolean result = false;
        try {
            result = StudentHomeworkJdbc.addHomework(homework);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //判断是否添加作业成功
        req.setAttribute("judge", result);
        req.setAttribute("type","addHomework");
        req.getRequestDispatcher("function/judge.jsp").forward(req,resp);
    }
}
*/
