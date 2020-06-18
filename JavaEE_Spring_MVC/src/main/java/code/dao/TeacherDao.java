package code.dao;

import code.model.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDao {
    boolean add(Teacher teacher);



    Teacher getTeacherbyid(String id);
}
