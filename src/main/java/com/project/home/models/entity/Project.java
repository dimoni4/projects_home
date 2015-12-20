package com.project.home.models.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "PROJECT")
@NamedQueries ({
        @NamedQuery (name = Project.ALL, query = "select p from Project p where p.active = true")
})
public class Project implements java.io.Serializable {

    public static final String ALL = "Project.ALL";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "project")
    private Set<Access> accessList = new HashSet<Access>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "project")
    private Set<Instance> instances = new HashSet<Instance>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "project")
    private Set<Service> services = new HashSet<Service>();

    private String description;

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

    public Project setActive(boolean active) {
        this.active = active;
        return this;
    }

    public Project add(Access acess) {
        acess.setProject(this);
        accessList.add(acess);
        return this;
    }

    public Set<Access> getAccessList() {
        return new HashSet<Access>(accessList);
    }

    public Project add(Instance instance) {
        instance.setProject(this);
        instances.add(instance);
        return this;
    }

    public Set<Instance> getInstances() {
        return new HashSet<Instance>(instances);
    }

    public Project add(Service service) {
        service.setProject(this);
        services.add(service);
        return this;
    }

    public Set<Service> getServices() {
        return new HashSet<Service>(services);
    }

    public User getOwner() {
        for (Access projectAccess: accessList) {
            if(Access.Type.OWNER.equals(projectAccess.getAccessType())) {
                return projectAccess.getUser();
            }
        }
        return null;
    }

    public String getJenkinsUrl() {
        return getService(Service.Type.JENKINS);
    }

    public String getSonarUrl() {
        return getService(Service.Type.SONAR);
    }

    private String getService(Service.Type type) {
        for(Service service : services) {
            if(service.getType().equals(type)) {
                return service.getUrl();
            }
        }
        return null;
    }
}
