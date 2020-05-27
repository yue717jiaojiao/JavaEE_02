package com.example.demo.db.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Homework
 *
 * @author wangkm
 * @date 2020-05-07
 * @since 0.0.1
 */
@Data
@Entity
@Table(name = "homework")
public class Homework {
    @Id
    private Long id;

    private String title;
    private String content;

    private Date createTime;
    private Date updateTime;
}
