package com.example.demo.db.service;


import com.example.demo.db.mapper.BaseMapper;
import com.example.demo.db.model.StudentHomework;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * GenericService
 *
 * @author wangkm
 * @date 2020-05-07
 * @since 0.0.1
 */
public abstract class AbstractService<E, PK> {

    /**
     * getMapper
     * @return
     */
    protected abstract BaseMapper<E, PK> getMapper();

    public List<E> findAll(){
        return getMapper().findAll();
    }

    public Page<E> findAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<E> studentHomeworkPage = getMapper().findAll(pageable);
        return studentHomeworkPage;
    }

    public Page<E> findAll(E e, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Example<E> example = Example.of(e);
        Page<E> studentHomeworkPage = getMapper().findAll(example, pageable);
        return studentHomeworkPage;
    }

    public Page<E> findAll(Specification<E> specification, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<E> studentHomeworkPage = getMapper().findAll(specification, pageable);
        return studentHomeworkPage;
    }

}
