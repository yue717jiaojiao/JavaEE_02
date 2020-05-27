package com.example.demo.Controller;


import com.example.demo.core.request.StudentHomeworkPageRequest;
import com.example.demo.core.response.DataResponses;
import com.example.demo.core.response.ListResponse;
import com.example.demo.core.response.PageResponse;
import com.example.demo.db.model.StudentHomework;
import com.example.demo.db.service.StudentHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ApiController {

    private final StudentHomeworkService studenthomeworkservice;


    public ApiController(StudentHomeworkService studenthomeworkservice ){
       this.studenthomeworkservice = studenthomeworkservice;
    }

    @RequestMapping()
    public StudentHomework addStudentHomework(@RequestBody StudentHomework studentHomework){
        studenthomeworkservice.getMapper().save(studentHomework);
        return null;
    }
/*    @RequestMapping("/homework/List")
    public DataResponses<List<StudentHomework>> homeworkList() {
        DataResponses<List<StudentHomework>> response = new DataResponses<>();
        List<StudentHomework> list = studenthomeworkservice.findAll();
        response.setData(list);
        return response;
    }*/
/*    @RequestMapping("/homework/List")
    public PageResponse<StudentHomework> homeworkList(@RequestBody(required=false) StudentHomeworkPageRequest request) {
        int page = request.getPage();
        int size = request.getSize();
        PageResponse<StudentHomework> response = new PageResponse<>();
        Page<StudentHomework> list = studenthomeworkservice.findAll(page,size);
        response.setData(list.getContent());
        response.setTotal(list.getTotalElements());

        return response;
    }*/
@RequestMapping("/homework/list")
public PageResponse<StudentHomework> homeworkList(@RequestBody(required = false) StudentHomeworkPageRequest request){
    if(request.getHomeworkId()!=null) {
        int page = request.getPage();
        int size = request.getSize();
        PageResponse<StudentHomework> response = new PageResponse<>();
        StudentHomework studentHomework = StudentHomework.builder()
                .studentId(null)
                .homeworkId(request.getHomeworkId())
                .build();

        Long studentHomeworkId = request.getHomeworkId();

        Specification<StudentHomework> specification = new Specification<StudentHomework>() {

            @Override
            public Predicate toPredicate(Root<StudentHomework> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();

                Predicate shPredicate = criteriaBuilder.greaterThan(root.get("homeworkId"), studentHomeworkId);
                predicateList.add(shPredicate);

                criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")));

                Predicate[] predicates = new Predicate[predicateList.size()];
                return criteriaBuilder.and(predicateList.toArray(predicates));
            }
        };

        Page<StudentHomework> list = studenthomeworkservice.findAll(specification, page, size);
        response.setData(list.getContent());
        response.setTotal(list.getTotalElements());
        return response;
    }
    return null;
}
}
