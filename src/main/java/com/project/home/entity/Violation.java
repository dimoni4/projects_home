package com.project.home.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VIOLATION")
@NamedQueries ({
        @NamedQuery (name = Violation.FIND_ALL, query = "select v from Violation v"),
        @NamedQuery (name = Violation.FIND_BY_INSTANCE_ID, query = "select v from Violation v where v.instance.id = :instanceId"),
        @NamedQuery (name = Violation.FIND_BY_PROJECT_ID, query = "select v from Violation v where v.instance.project.id = :projectId")
})
public class Violation implements java.io.Serializable {
    public static final String FIND_ALL = "Violation.findAll";
    public static final String FIND_BY_INSTANCE_ID = "Violation.findByInstanceId";
    public static final String FIND_BY_PROJECT_ID = "Violation.findByProjectId";

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
