package com.project.home.entity;

import javax.persistence.*;

@Entity
@Table(name = "VIOLATION")
public class Violation implements java.io.Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String description;
    private Instance.Type type;
    private String url;
    private String version;
    private CheckCreteria checkCreteria;
    private Status status;

    @ManyToOne
    private Instance instance;


}
