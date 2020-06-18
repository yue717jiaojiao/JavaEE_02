package code.service;

import code.dao.HomeworkDao;
import code.dao.StudentDao;
import code.dao.StudentHomeworkDao;
import code.dao.TeacherDao;
import code.model.Homework;
import code.model.Student;
import code.model.StudentHomework;
import code.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 连接数据库，进行增删改查操作
 */
@Service
public class AllServiceImpl implements AllService{
    private final HomeworkDao homeworkDao;
    private final StudentDao studentDao;
    private final StudentHomeworkDao studentHomeworkDao;
    private final TeacherDao teacherDao;

    @Autowired
    public AllServiceImpl(HomeworkDao homeworkDao, StudentDao studentDao, StudentHomeworkDao studentHomeworkDao, TeacherDao teacherDao) {
        this.homeworkDao = homeworkDao;
        this.studentDao = studentDao;
        this.studentHomeworkDao = studentHomeworkDao;
        this.teacherDao = teacherDao;
    }

    @Override
    public List<StudentHomework> selectAll(String id) {
        return studentHomeworkDao.getAll(id);
    }

    @Override
    public boolean addHomework(HttpServletRequest request){
        Homework homework = new Homework();

        homework.setId((int) Long.parseLong(request.getParameter("id")));
        homework.setTitle(request.getParameter("title"));
        homework.setContent(request.getParameter("content"));
        Date date = new Date();
        homework.setCreateTime(date);
        return homeworkDao.add(homework);
    }

    @Override
    public boolean addStudent(HttpServletRequest request){
        Student student = new Student();

        student.setId((int) Long.parseLong(request.getParameter("id")));
        student.setSname(request.getParameter("name"));
        student.setPassword(request.getParameter("password"));
        Date date = new Date();
        student.setCreateTime(date);
        return studentDao.add(student);
    }

    @Override
    public boolean addTeacher(HttpServletRequest request) {
        Teacher teacher = new Teacher();

        teacher.setId((int) Long.parseLong(request.getParameter("id")));
        teacher.setPassword(request.getParameter("password"));
        return teacherDao.add(teacher);
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
    public Student studentlogin(String id) {

        return studentDao.getStudentbyid(id);
    }

    @Override
    public Teacher teacherlogin(String id) {
        return teacherDao.getTeacherbyid(id);
    }

    @Override
    public boolean ifhave(HttpServletRequest req) {
        String studentId = req.getParameter("studentId");
        System.out.println(studentId);
        String homeworkId = req.getParameter("homeworkId");
        System.out.println(homeworkId);
        List<StudentHomework> a =studentHomeworkDao.ifhave(studentId,homeworkId);
        boolean tem = false;
        if(!a.isEmpty()){
            tem = true;
        }
        return tem;
    }

    @Override
    public boolean addStudentHomework(HttpServletRequest req){
        StudentHomework studentHomework = new StudentHomework();
        studentHomework.setStudentId((int) Long.parseLong(req.getParameter("studentId")));
        studentHomework.setHomeworkId((int) Long.parseLong(req.getParameter("homeworkId")));
        studentHomework.setHomeworkTitle(req.getParameter("title"));
        studentHomework.setHomeworkContent(req.getParameter("content"));
        studentHomework.setStudentAnswer(req.getParameter("student_answer"));
        Date date = new Date();
        studentHomework.setCreateTime(date);
        return studentHomeworkDao.add(studentHomework);
    }

    @Override
    public boolean changeStudentHomework(HttpServletRequest req) {
        StudentHomework studentHomework = new StudentHomework();
        studentHomework.setStudentId((int) Long.parseLong(req.getParameter("studentId")));
        studentHomework.setHomeworkId((int) Long.parseLong(req.getParameter("homeworkId")));
        studentHomework.setHomeworkTitle(req.getParameter("title"));
        studentHomework.setHomeworkContent(req.getParameter("content"));
        studentHomework.setStudentAnswer(req.getParameter("student_answer"));
        Date date = new Date();
        studentHomework.setCreateTime(date);
        return studentHomeworkDao.edit(studentHomework);
    }

}
