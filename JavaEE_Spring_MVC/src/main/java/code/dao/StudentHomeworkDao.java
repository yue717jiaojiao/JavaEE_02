package code.dao;

import code.model.StudentHomework;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: dengzhiwen
 * @Date: 2020/5/2 14:17
 */
@Repository
public interface StudentHomeworkDao {

    /**
     * 添加新的作业提交
     * @param studentHomework 学生提交的作业
     * @return 添加是否成功
     */
    boolean add(StudentHomework studentHomework);

    /**
     * 删除学生的作业
     * @param studentHomework 学生的作业
     * @return 删除是否成功
     */
    boolean delete(StudentHomework studentHomework);

    /**
     * 编辑学生作业
     * @param studentHomework 学生作业
     * @return 编辑是否成功
     */
    boolean edit(StudentHomework studentHomework);

    /**
     * 查看所有的学生作业内容
     * @param id 作业id
     * @return 学生计较的作业内容记录
     */
    List<StudentHomework> getAll(String id);
}
