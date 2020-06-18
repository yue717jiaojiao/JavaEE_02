package code.dao;

import code.model.StudentHomework;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentHomeworkDao {


    boolean add(StudentHomework studentHomework);


    boolean delete(StudentHomework studentHomework);


    boolean edit(StudentHomework studentHomework);


    List<StudentHomework> getAll(String id);
}
