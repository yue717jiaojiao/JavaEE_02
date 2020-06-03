package code.service;

import code.model.Homework;
import code.model.StudentHomework;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: dengzhiwen
 * @Date: 2020/5/2 14:46
 */
public interface AllService {
    /**
     * 添加作业
     * @param request http请求
     * @return 是否添加成功
     */
    boolean addHomework(HttpServletRequest request);

    /**
     * 添加学生
     * @param request http请求
     * @return 是否添加成功
     */
    boolean addStudent(HttpServletRequest request);

    /**
     * 添加学生提交的作业内容
     * @param req http请求
     * @return 是否添加成功
     */
    boolean addStudentHomework(HttpServletRequest req);

    /**
     * 查看指定id的作业提交内容
     * @param id 作业id
     * @return 学生提交的作业内容记录
     */
    List<StudentHomework> selectAll(String id);

    /**
     * 查看所有的作业
     * @return 返回作业记录集合
     */
    List<Homework> showHomework();

    /**
     * 查看某次作业的具体内容
     * @param id 作业id
     * @return 作业记录
     */
    Homework showHomeworkDetails(String id);


}
