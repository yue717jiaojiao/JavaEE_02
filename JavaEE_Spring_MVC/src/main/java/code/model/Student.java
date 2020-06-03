package code.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Student {
    private long id;
    private String sname;
    private Date createTime;
    private Date updateTime;
}