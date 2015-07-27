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

    public void setActive(boolean active) {
        this.active = active;
    }

    public Project add(Access acess) {
        accessList.add(acess);
        return this;
    }

    public Set<Access> getProjectAccessList() {
        return new HashSet<Access>(accessList);
    }

    public Project add(Instance instance) {
        instances.add(instance);
        return this;
    }

    public Set<Instance> getProjectInstances() {
        return new HashSet<Instance>(instances);
    }

    public Project add(Service service) {
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
}
