package com.project.home.models.entity;


import javax.persistence.*;

@Entity
@Table(name = "SERVICE")
public class Service implements java.io.Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Project project;

    private Type type;
    private String url;
    private Status status;

    public Service() {
    }

    public Service(Type type, String url) {
        this.type = type;
        this.url = url;
        this.status = Status.UNKNOWN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public Service setProject(Project project) {
        this.project = project;
        return this;
    }

    public Type getType() {
        return type;
    }

    public Service setType(Type type) {
        this.type = type;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Service setUrl(String url) {
        this.url = url;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Service setStatus(Status status) {
        this.status = status;
        return this;
    }

    public static enum Type {
        JENKINS, SONAR, LOG, LOG_TEST, GIT
    }
}
