package com.project.home.models.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
@Entity
@Table(name = "USER")
@NamedQueries ({
        @NamedQuery (name = User.FIND_BY_EMAIL, query = "select a from User a where a.email = :email")
})
public class User implements java.io.Serializable {

    public static final String FIND_BY_EMAIL = "User.findByEmail";

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;
    private String role;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Access> projectAccessList = new HashSet<Access>();

    public User() {
    }

    public User(String email) {
        this.email = email;
    }


    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User add(Access projectAccess) {
        projectAccessList.add(projectAccess);
        return this;
    }

    public Set<Access> getProjectAccessList() {
        return new HashSet<Access>(projectAccessList);
    }
}
