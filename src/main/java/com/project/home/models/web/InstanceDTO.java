package com.project.home.models.web;

import com.project.home.models.entity.*;

public class InstanceDTO  {
    private String description;
    private Instance.Type type;
    private String url;
    private String version;
    private Status status;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instance.Type getType() {
        return type;
    }

    public void setType(Instance.Type type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
