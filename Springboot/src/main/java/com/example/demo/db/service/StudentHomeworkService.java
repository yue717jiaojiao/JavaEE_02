package com.example.demo.db.service;

import com.example.demo.db.mapper.StudentHomeworkMapper;
import com.example.demo.db.model.StudentHomework;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentHomeworkService extends BaseService<StudentHomework, Long, StudentHomeworkMapper>{

/*    private StudentHomeworkMapper StudentHomeworkmapper;

    public StudentHomeworkService(StudentHomeworkMapper StudentHomeworkmapper){
        this.StudentHomeworkmapper =StudentHomeworkmapper;
    }

    public List<StudentHomework> findAll(){
        System.out.println(StudentHomeworkmapper.findAll());
        return StudentHomeworkmapper.findAll();

    }
    public Object test(){
        StudentHomeworkmapper.delete(new StudentHomework());
        int page = 0;
        int size = 3;
        PageRequest pageable = PageRequest.of(page,size);
        Page<StudentHomework> studenthomeworkPage = StudentHomeworkmapper.findAll(pageable);
        studenthomeworkPage.getTotalElements();
        return null;
    }

    public Page<StudentHomework> findAll(int page, int size) {
        PageRequest pageable = PageRequest.of(page,size);
        Page<StudentHomework> studenthomeworkPage = StudentHomeworkmapper.findAll(pageable);

        return  studenthomeworkPage;
    }*/

}
