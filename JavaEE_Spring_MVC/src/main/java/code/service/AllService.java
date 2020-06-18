package code.service;

import code.model.Homework;
import code.model.Student;
import code.model.StudentHomework;
import code.model.Teacher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface AllService {

    boolean addHomework(HttpServletRequest request);


    boolean addStudent(HttpServletRequest request);

    boolean addTeacher(HttpServletRequest request);

    boolean addStudentHomework(HttpServletRequest req);

    boolean changeStudentHomework(HttpServletRequest req);

    List<StudentHomework> selectAll(String id);


    List<Homework> showHomework();


    Homework showHomeworkDetails(String id);

    Student studentlogin(String id);

    Teacher teacherlogin(String id);

    boolean ifhave(HttpServletRequest req);


}
