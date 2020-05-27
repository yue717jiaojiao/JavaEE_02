package com.example.demo.db.service;
import com.example.demo.db.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * BaseService
 *
 * @author wangkm
 * @date 2020-05-07
 * @since 0.0.1
 */
public abstract class BaseService<E, PK, M extends BaseMapper<E, PK>> extends AbstractService<E, PK> {

    @Autowired
    protected M mapper;

    @Override
    public BaseMapper<E, PK> getMapper() {
        return mapper;
    }
}
