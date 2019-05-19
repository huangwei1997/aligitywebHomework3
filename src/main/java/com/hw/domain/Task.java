package com.hw.domain;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Task {
    private Integer id;
    private String content;
    private Date createdTime;

    public Task(){}

    public Task(int id , String content , Date createdTime){
        this.id = id;
        this.content = content;
        this.createdTime = createdTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
