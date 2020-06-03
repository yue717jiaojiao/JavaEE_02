package code.dao;

import code.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: dengzhiwen
 * @Date: 2020/5/2 14:17
 */
@Repository
public interface StudentDao {

    /**
     * 添加学生
     * @param student 学生
     * @return 添加是否成功
     */
    boolean add(Student student);

    /**
     * 删除学生
     * @param student 学生
     * @return 删除是否成功
     */
    boolean delete(Student student);

    /**
     * 选择所有学生
     * @return 学生记录
     */
    List<Student> select();
}
