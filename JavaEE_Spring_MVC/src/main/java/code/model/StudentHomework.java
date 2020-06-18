package code.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class StudentHomework {

    private int studentId;
    private int homeworkId;
    private String homeworkTitle;
    private String homeworkContent;
    private String studentAnswer;
    private Date createTime;
    private Date updateTime;
}
