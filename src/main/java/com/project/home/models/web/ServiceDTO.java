package com.project.home.models.web;


import com.project.home.models.entity.Project;
import com.project.home.models.entity.Service;
import com.project.home.models.entity.Status;

public class ServiceDTO {
    private Project project;
    private Service.Type type;
    private String url;
    private Status status;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Service.Type getType() {
        return type;
    }

    public void setType(Service.Type type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
