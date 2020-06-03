package code.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * StudentHomework
 *
 * @author wangkm
 * @date 2020-03-05
 * @since 0.0.1
 */
@Setter
@Getter
public class StudentHomework {
    private long id;
    private long studentId;
    private long homeworkId;
    private String homeworkTitle;
    private String homeworkContent;
    private String studentAnswer;
    private Date createTime;
    private Date updateTime;
}
