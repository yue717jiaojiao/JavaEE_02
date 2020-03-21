package com.java.code.model;

import java.util.Date;

public class Student {

    private long sid;

    private String sname;

    private Date createTime;

    private Date updateTime;

    public long getId() {
        return sid;
    }

    public void setId(long sid) {
        this.sid = sid;
    }

    public String getName() {
        return sname;
    }

    public void setName(String sname) {
        this.sname = sname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
