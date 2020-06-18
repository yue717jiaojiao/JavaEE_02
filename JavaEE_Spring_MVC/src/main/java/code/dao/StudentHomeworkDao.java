package code.dao;

import code.model.StudentHomework;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentHomeworkDao {


    boolean add(StudentHomework studentHomework);


    boolean delete(StudentHomework studentHomework);


    boolean edit(StudentHomework studentHomework);


    List<StudentHomework> getAll(String id);

    List<StudentHomework> ifhave(@Param("studentId") String studentId, @Param("homeworkId") String homeworkId);
}
