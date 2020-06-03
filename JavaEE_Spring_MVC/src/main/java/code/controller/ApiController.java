package code.controller;

import code.service.AllServiceImpl;
import code.model.Homework;
import code.model.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: dengzhiwen
 * @Date: 2020/3/28 17:58
 */

@Controller
public class ApiController {

    private final AllServiceImpl allService;

    @Autowired
    public ApiController(AllServiceImpl allService) {
        this.allService = allService;
    }

    @RequestMapping(path = "/show_Homework", method = RequestMethod.GET)
    public ModelAndView showHomework() {
        List<Homework> list = allService.showHomework();
        return new ModelAndView("/function/check_homework.jsp", "list", list);
    }

    //提交作业，获取所有作业
    @RequestMapping(path = "/Add_student_homework", method = RequestMethod.GET)
    public ModelAndView getHomework() {
        List<Homework> list = allService.showHomework();
        return new ModelAndView("/function/Add_student_homework_1.jsp", "list", list);
    }

    //提交作业2，读取指定信息
    @RequestMapping(path = "/submit_homework", method = RequestMethod.GET)
    public ModelAndView willSubmit() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String id = request.getParameter("id");

        Homework homework = allService.showHomeworkDetails(id);
        return new ModelAndView("function/Add_student_homework.jsp", "homework", homework);
    }
    //最后一个提交
    @RequestMapping(path = "/submit", method = RequestMethod.POST)
    public void submit() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        HttpServletResponse resp = attributes.getResponse();

        boolean result = allService.addStudentHomework(req);
        //用于判断是否提交成功
        req.setAttribute("judge", result);
        req.setAttribute("type", "addStudentHomework");
        try {
            req.getRequestDispatcher("function/judge.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(path = "/submitted_homework", method = RequestMethod.GET)
    public ModelAndView query() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String id = request.getParameter("id");
        //从数据库读取指定作业id的所有记录
        List<StudentHomework> list = allService.selectAll(id);
        return new ModelAndView("function/Check_situation.jsp", "list", list);
    }

    @RequestMapping(path = "/Add_homework", method = RequestMethod.POST)
    public void addHomework() {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse resp = attributes.getResponse();
        boolean result = allService.addHomework(request);

        //用来判断是否添加作业成功
        request.setAttribute("isOK", result);
        request.setAttribute("type", "addHomework");
        try {
            request.getRequestDispatcher("function/judge.jsp").forward(request, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/Add_student", method = RequestMethod.POST)
    public void addStudent() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse resp = attributes.getResponse();

        boolean result = allService.addStudent(request);

        //用来判断是否添加学生成功
        request.setAttribute("isOK", result);
        request.setAttribute("type", "addStudent");
        try {
            request.getRequestDispatcher("function/judge.jsp").forward(request, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


}
