package com.project.home.entity;

import javax.persistence.*;

@Entity
@Table(name = "PROJECT_ACCESS")
public class Access implements java.io.Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Project project;

    private Type accessType;

    public Access(User user, Type accessType) {
        this.user = user;
        this.accessType = accessType;
    }

    public Access() {
    }

    public static enum Type {
        OWNER, VISITOR
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Type getAccessType() {
        return accessType;
    }

    public void setAccessType(Type accessType) {
        this.accessType = accessType;
    }
}
