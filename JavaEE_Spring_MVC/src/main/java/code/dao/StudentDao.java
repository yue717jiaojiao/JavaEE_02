package code.dao;

import code.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentDao {


    boolean add(Student student);


    boolean delete(Student student);


    List<Student> select();

    Student getStudentbyid(String id);


}
