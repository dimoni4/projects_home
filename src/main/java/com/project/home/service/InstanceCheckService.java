package com.project.home.service;

import com.project.home.entity.Instance;
import com.project.home.entity.Project;
import com.project.home.entity.Status;
import com.project.home.repository.InstanceRepository;
import com.project.home.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InstanceCheckService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private InstanceRepository instanceRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    private CheckerConnector checkerConnector = new CheckerConnector();

    public void checkInstances() {
        for (Project project : projectRepository.getAllProjects()) {
            for (Instance instance : project.getProjectInstances()) {
                if (!instanceWorks(instance)) {
                    instance.setStatus(Status.NE_OK);
                    instanceRepository.save(instance);
                    emailSenderService.send(project.getOwner().getEmail(), "Проект " + project.getName(), "Проект " + project.getName() + " не работает");
                }
            }
        }
    }

    private boolean instanceWorks(Instance instance) {
        CheckerConnector.Response response = checkerConnector.send(instance.getUrl());
        if (response.isSuccess()) {
            switch (instance.getCheckCreteria()) {
                case SEARCH_WORD:
                    if (!response.getResponseBody().contains(instance.getCheckCreteria().getValue())) {
                        return false;
                    }
                    break;
                case HTTP_RESPONSE_CODE:
                    if (response.getResponseCode() != 200) {
                        return false;
                    }
            }
        } else {
            return false;
        }
        return true;
    }

    public void setCheckerConnector(CheckerConnector checkerConnector) {
        this.checkerConnector = checkerConnector;
    }
}
