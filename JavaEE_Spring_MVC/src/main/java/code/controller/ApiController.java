package code.controller;

import code.model.Student;
import code.model.Teacher;
import code.service.AllServiceImpl;
import code.model.Homework;
import code.model.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class ApiController {

    private final AllServiceImpl allService;

    @Autowired
    public ApiController(AllServiceImpl allService) {
        this.allService = allService;
    }

    @RequestMapping(path = "/show_homework", method = RequestMethod.GET)
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
    public ModelAndView willSubmit() throws UnsupportedEncodingException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        System.out.println(id);
        Homework homework = allService.showHomeworkDetails(id);
        return new ModelAndView("function/Add_student_homework.jsp", "homework", homework);
    }
    //最后一个提交
    @RequestMapping(path = "/submit", method = RequestMethod.POST)
    public ModelAndView submit() throws UnsupportedEncodingException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        HttpServletResponse resp = attributes.getResponse();
        req.setCharacterEncoding("UTF-8");
        boolean result = allService.addStudentHomework(req);
        //用于判断是否提交成功

        ModelMap model = new ModelMap();
        model.addAttribute("judge", result);
        model.addAttribute("type", "addStudentHomework");

        return new ModelAndView("result.jsp", "model", model);

    }

    @RequestMapping(path = "/submitted_homework", method = RequestMethod.GET)
    public ModelAndView query() throws UnsupportedEncodingException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        //从数据库读取指定作业id的所有记录
        List<StudentHomework> list = allService.selectAll(id);
        return new ModelAndView("function/Check_situation.jsp", "list", list);
    }

    @RequestMapping(path = "/Add_homework", method = RequestMethod.POST)
    public ModelAndView addHomework() throws UnsupportedEncodingException {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse resp = attributes.getResponse();
        request.setCharacterEncoding("UTF-8");
        boolean result = allService.addHomework(request);
        //用来判断是否添加作业成功

        ModelMap model = new ModelMap();
        model.addAttribute("judge", result);
        model.addAttribute("type", "addHomework");

        return new ModelAndView("result.jsp", "model", model);
    }

    @RequestMapping(path = "/Add_student",method = RequestMethod.POST)
    public ModelAndView addStudent() throws UnsupportedEncodingException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse resp = attributes.getResponse();
        request.setCharacterEncoding("UTF-8");
        boolean result = allService.addStudent(request);

        //用来判断是否添加学生成功
        ModelMap model = new ModelMap();
            model.addAttribute("judge", result);
            model.addAttribute("type", "addStudent");

        return new ModelAndView("result.jsp", "model", model);
    }
    @RequestMapping(path = "/Add_teacher",method = RequestMethod.POST)
    public ModelAndView addTeacher() throws UnsupportedEncodingException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse resp = attributes.getResponse();
        request.setCharacterEncoding("UTF-8");
        boolean result = allService.addTeacher(request);

        ModelMap model = new ModelMap();
        model.addAttribute("judge", result);
        model.addAttribute("type", "addTeacher");

        return new ModelAndView("result.jsp", "model", model);
    }
    //登录
    @RequestMapping(path = "/student_login", method = RequestMethod.POST)
    public ModelAndView studentlogin() throws UnsupportedEncodingException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        Student student = allService.studentlogin(id);

        if (password.equals(student.getPassword())) {

            return new ModelAndView("function/studentpart1.jsp");
        } else {
            return null;
        }
    }
    @RequestMapping(path = "/teacher_login", method = RequestMethod.POST)
    public ModelAndView teacherlogin() throws UnsupportedEncodingException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        Teacher teacher = allService.teacherlogin(id);

        if (password.equals(teacher.getPassword())) {

            return new ModelAndView("function/teacherpart1.jsp");
        } else {
            return null;
        }
    }
}
