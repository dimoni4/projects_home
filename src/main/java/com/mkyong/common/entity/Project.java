package com.mkyong.common.entity;

import javax.persistence.*;

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
    private String url;
    private String description;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Project setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Project setDescription(String description) {
        this.description = description;
        return this;
    }
}