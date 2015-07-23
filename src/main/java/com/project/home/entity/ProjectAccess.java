package com.project.home.entity;

import javax.persistence.*;

@Entity
@Table(name = "PROJECT_ACCESS")
public class ProjectAccess implements java.io.Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Project project;

    private com.project.home.entity.AccessType accessType;

    public ProjectAccess(User user, Project project, com.project.home.entity.AccessType accessType) {
        this.user = user;
        this.project = project;
        this.accessType = accessType;
    }

    public ProjectAccess() {
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

    public com.project.home.entity.AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(com.project.home.entity.AccessType accessType) {
        this.accessType = accessType;
    }
}
