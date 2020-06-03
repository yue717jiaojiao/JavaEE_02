package code.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Homework {
    private long id;
    private String Title;
    private String Content;
    private Date createTime;
    private Date updateTime;

}
