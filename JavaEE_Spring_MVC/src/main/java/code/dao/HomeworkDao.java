package code.dao;

import code.model.Homework;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: dengzhiwen
 * @Date: 2020/5/2 13:47
 */
@Repository
public interface HomeworkDao {

    /**
     * 添加新作业
     * @author: dzw
     * @Date:  2020-05-02 13:49:53
     * @param homework 添加的作业
     * @return true or false
     */
    boolean add(Homework homework);


    /**
     * 删除指定作业
     * @param homework 将要删除的作业
     * @return true or false
     */
    boolean delete(Homework homework);


    /**
     * 修改指定的祖业
     * @param homework 将要修改的作业
     * @return true or false
     */
    boolean change(Homework homework);
    /**
     * 选择作业
     * @return 返回选择结果
     */
    List<Homework> selectAll();


    /**
     * 选择指定作业记录
     * @param id 作业id
     * @return 返回为id的作业记录
     */
    Homework selectById(String id);


}
