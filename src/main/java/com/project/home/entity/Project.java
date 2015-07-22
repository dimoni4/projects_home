package com.project.home.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "PROJECT")
@NamedQueries ({
        @NamedQuery (name = Project.ALL, query = "select p from Project p")
})
public class Project implements java.io.Serializable {

    public static final String ALL = "Project.ALL";

    @Id
    @GeneratedValue
    @Column(name = "artist_id")
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "project")
    private Set<ProjectAccess> projectAccessList = new HashSet<ProjectAccess>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "project")
    private Set<Instance> projectInstances = new HashSet<Instance>();

    private String description;

    /* URLS */
    private String jenkinsUrl;
    private String repositoryUrl;
    private String logsUrl;
    private String sonarUrl;

    /* STATUSES */
    private Status jenkinsStatus;

    private Status sonarStatus;


    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Project setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getJenkinsUrl() {
        return jenkinsUrl;
    }

    public Project setJenkinsUrl(String jenkinsUrl) {
        this.jenkinsUrl = jenkinsUrl;
        return this;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public Project setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
        return this;
    }

    public String getLogsUrl() {
        return logsUrl;
    }

    public Project setLogsUrl(String logsUrl) {
        this.logsUrl = logsUrl;
        return this;
    }

    public String getSonarUrl() {
        return sonarUrl;
    }

    public Project setSonarUrl(String sonarUrl) {
        this.sonarUrl = sonarUrl;
        return this;
    }

    public Status getJenkinsStatus() {
        return jenkinsStatus;
    }

    public Project setJenkinsStatus(Status jenkinsStatus) {
        this.jenkinsStatus = jenkinsStatus;
        return this;
    }

    public Status getSonarStatus() {
        return sonarStatus;
    }

    public Project setSonarStatus(Status sonarStatus) {
        this.sonarStatus = sonarStatus;
        return this;
    }

    public Project add(ProjectAccess projectAccess) {
        projectAccessList.add(projectAccess);
        return this;
    }

    public Set<ProjectAccess> getProjectAccessList() {
        return new HashSet<ProjectAccess>(projectAccessList);
    }

    public Project add(Instance instance) {
        projectInstances.add(instance);
        return this;
    }

    public Set<Instance> getProjectInstances() {
        return new HashSet<Instance>(projectInstances);
    }

    public User getOwner() {
        for (ProjectAccess projectAccess: projectAccessList) {
            if(AccessType.OWNER.equals(projectAccess.getAccessType())) {
                return projectAccess.getUser();
            }
        }
        return null;
    }

    public void setProjectAccessList(Set<ProjectAccess> projectAccessList) {
        this.projectAccessList = projectAccessList;
    }
}
