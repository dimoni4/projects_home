package com.project.home.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


public class ViolationsEntry {
    @JsonProperty("x")
    public Date dateTime;

    @JsonProperty("y")
    public Integer count;

    public ViolationsEntry(Date dateTime) {
        this.dateTime = dateTime;
        this.count = 1;
    }
}
