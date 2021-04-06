package com.satya.subm.v1.model;

import java.util.Date;

public class Task {
    private int id;
    private String title;
    private String desc;
    private Date date;
    private TaskStatus status;
    private TaskPriority priority;
    private String note;
    private Date completeDate;

    public Task() {
    }

    public Task(int id, String title, String desc, TaskPriority priority) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.date = new Date();
        this.status = TaskStatus.ACTIVE;
        this.priority = priority;
        this.note = "";
        this.completeDate = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }
}
