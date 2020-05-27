package com.example.demo.db.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * BaseMapper
 *
 * @author wangkm
 * @date 2020-05-07
 * @since 0.0.1
 */
@NoRepositoryBean
public interface BaseMapper<E, PK> extends JpaRepository<E, PK>, JpaSpecificationExecutor<E> {
}
