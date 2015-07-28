package com.project.home.service;

import com.project.home.entity.Instance;
import com.project.home.entity.Project;
import com.project.home.entity.Status;
import com.project.home.entity.Violation;
import com.project.home.repository.InstanceRepository;
import com.project.home.repository.ProjectRepository;
import com.project.home.util.DefaultResult;
import com.project.home.util.ServiceResult;
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
            for (Instance instance : project.getInstances()) {
                ServiceResult instanceWorkResult = instanceWorks(instance);
                if (instanceWorkResult.isFail()) {
                    instance.setStatus(Status.NE_OK);
                    instance.add(new Violation(instanceWorkResult.getMessage()));
                    instanceRepository.save(instance);
                    emailSenderService.send(project.getOwner().getEmail(), "Проект " + project.getName(),
                            "Проект " + project.getName() + " не работает. " + instanceWorkResult.getMessage());
                }
            }
        }
    }

    private ServiceResult instanceWorks(Instance instance) {
        ServiceResult serviceResult = new DefaultResult(true);
        try {
            CheckerConnector.Response response = checkerConnector.send(instance.getUrl());
            switch (instance.getCheckCreteria().getType()) {
                case SEARCH_WORD:
                    String searchWord = instance.getCheckCreteria().getCheckWord();
                    if (!response.getResponseBody().contains(searchWord)) {
                        serviceResult.setFail("Response body does not contain \"" + searchWord + "\" word.");
                    }
                    break;
                case HTTP_RESPONSE_CODE:
                    int responseCode = response.getResponseCode();
                    if (responseCode != 200) {
                        serviceResult.setFail("Response code \""+ responseCode + "\" does not equal \"200\".");
                    }
            }
        } catch (Exception exception) {
            serviceResult.setFail(exception);
        }
        return serviceResult;
    }

    public void setCheckerConnector(CheckerConnector checkerConnector) {
        this.checkerConnector = checkerConnector;
    }
}
