package com.project.home.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VIOLATION")
public class Violation implements java.io.Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String url;
    private String message;
    private Date dateTime;

    @ManyToOne
    private Instance instance;

    public Violation() {
    }

    public Violation(String message) {
        this.message = message;
        this.dateTime = new Date();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instance getInstance() {
        return instance;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
        this.url = instance.getUrl();
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
