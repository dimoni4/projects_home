package com.project.home.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "INSTANCE")
public class Instance implements java.io.Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String description;
    private Type type;
    private String url;
    private String version;
    private Status status;

    @Embedded
    private CheckCreteria checkCreteria;

    @ManyToOne
    private Project project;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "instance")
    private Set<Violation> violations = new HashSet<Violation>();

    public enum Type {
        TEST, STAGE, PRODUCTION
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



    public Set<Violation> getViolations() {
        return new HashSet<Violation>(violations);
    }

    public Instance add(Violation violation) {
        violation.setInstance(this);
        violations.add(violation);
        return this;
    }
}
