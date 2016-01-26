package com.project.home.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "INSTANCE")
public class Instance implements java.io.Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String description;
    private Type type;
    private String url;
    private String version = "";
    private Status status;

    @Embedded
    private CheckCreteria checkCreteria;

    @ManyToOne
    private Project project;

    public enum Type {
        TEST, STAGE, PROD
    }

    public Instance(Type type, String url) {
        this.type = type;
        this.url = url;
        this.status = Status.UNKNOWN;
    }

    public Instance() {
        checkCreteria = new CheckCreteria();
    }

    public Long getId() {
        return id;
    }

    public Instance setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Instance setDescription(String description) {
        this.description = description;
        return this;
    }

    public Type getType() {
        return type;
    }

    public Instance setType(Type type) {
        this.type = type;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Instance setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public Instance setVersion(String version) {
        this.version = version;
        return this;
    }

    public CheckCreteria getCheckCreteria() {
        return checkCreteria;
    }

    public boolean hasCheckCreteria() {
        return checkCreteria != null;
    }

    public Instance setCheckCreteria(CheckCreteria checkCreteria) {
        this.checkCreteria = checkCreteria;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Instance setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Project getProject() {
        return project;
    }

    public Instance setProject(Project project) {
        this.project = project;
        return this;
    }
}
