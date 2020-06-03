package code.service;

import code.dao.HomeworkDao;
import code.dao.StudentDao;
import code.dao.StudentHomeworkDao;
import code.model.Homework;
import code.model.Student;
import code.model.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 连接数据库，进行增删改查操作
 * @author: dengzhiwen
 * @Date: 2020/3/8 11:19
 */
@Service
public class AllServiceImpl implements AllService{
    private final HomeworkDao homeworkDao;
    private final StudentDao studentDao;
    private final StudentHomeworkDao studentHomeworkDao;


    @Autowired
    public AllServiceImpl(HomeworkDao homeworkDao, StudentDao studentDao, StudentHomeworkDao studentHomeworkDao) {
        this.homeworkDao = homeworkDao;
        this.studentDao = studentDao;
        this.studentHomeworkDao = studentHomeworkDao;
    }

    @Override
    public List<StudentHomework> selectAll(String id) {
        return studentHomeworkDao.getAll(id);
    }

    @Override
    public boolean addHomework(HttpServletRequest request){
        Homework homework = new Homework();

        homework.setTitle(request.getParameter("title"));
        homework.setContent(request.getParameter("content"));
        Date date = new Date();
        homework.setCreateTime(date);
        return homeworkDao.add(homework);
    }

    @Override
    public boolean addStudent(HttpServletRequest request){
        Student student = new Student();
        student.setId(Long.parseLong(request.getParameter("id")));
        student.setSname(request.getParameter("name"));
        Date date = new Date();
        student.setCreateTime(date);
        return studentDao.add(student);
    }

    @Override
    public List<Homework> showHomework(){
        return homeworkDao.selectAll();
    }

    @Override
    public Homework showHomeworkDetails(String id){
        return homeworkDao.selectById(id);
    }

    @Override
    public boolean addStudentHomework(HttpServletRequest req){
        StudentHomework studentHomework = new StudentHomework();
        studentHomework.setStudentId(Long.parseLong(req.getParameter("studentId")));
        studentHomework.setHomeworkId(Long.parseLong(req.getParameter("homeworkId")));
        studentHomework.setHomeworkTitle(req.getParameter("title"));
        studentHomework.setHomeworkContent(req.getParameter("content"));
        Date date = new Date();
        studentHomework.setCreateTime(date);
        return studentHomeworkDao.add(studentHomework);
    }

}
