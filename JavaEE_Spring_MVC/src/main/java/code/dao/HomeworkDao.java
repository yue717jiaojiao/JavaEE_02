package code.dao;

import code.model.Homework;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HomeworkDao {


    boolean add(Homework homework);

    boolean delete(Homework homework);


    boolean change(Homework homework);

    List<Homework> selectAll();


    Homework selectById(String id);


}
