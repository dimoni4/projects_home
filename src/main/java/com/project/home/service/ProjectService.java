package com.project.home.service;

import com.project.home.repository.ProjectRepository;
import com.project.home.repository.UserRepository;
import com.project.home.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@org.springframework.stereotype.Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    protected void initialize() {
        userRepository.save(new User("ilshyma", "123", "ROLE_USER"));
        userRepository.save(new User("admin", "admin", "ROLE_ADMIN"));

        User vetrov = new User("vetrovs@ua.fm", "123", "ROLE_USER");
        userRepository.save(vetrov);
        Project testProject = new Project();
        projectRepository.save(
                testProject
                        .setName("Test1")
                        .setDescription("Best project")
                        .add(new Access(
                                vetrov,
                                testProject,
                                Access.Type.OWNER))
                        .add(new Instance()
                                .setUrl("http://google.com")
                                .setCheckCreteria(CheckCreteria.SEARCH_WORD.setValue("google"))
                                .setStatus(Status.OK)
                                .setType(Instance.Type.PRODUCTION)
                                .setDescription("trlolo")
                                .setProject(testProject)
                                .setVersion("1.1"))
                        .add(new Service()
                                .setType(Service.Type.JENKINS)
                                .setUrl("i.ua")
                                .setStatus(Status.OK))
//                        .setJenkinsStatus(Status.NE_OK)
//                        .setJenkinsUrl("http://jenkins.ua")
//                        .setSonarStatus(Status.NE_OK)
//                        .setSonarUrl("http://jenkins.ua")
        );
    }
}
