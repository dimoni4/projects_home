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
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "asdf"))
                                .setStatus(Status.OK)
                                .setType(Instance.Type.PRODUCTION)
                                .setDescription("trlolo")
                                .setVersion("1.1"))
                        .add(new Instance()
                                .setUrl("http://google.com")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "google"))
                                .setStatus(Status.OK)
                                .setType(Instance.Type.TEST)
                                .setDescription("trlolo")
                                .setVersion("1.2"))
                        .add(new Service()
                                .setType(Service.Type.JENKINS)
                                .setUrl("i.ua")
                                .setStatus(Status.OK))
        );
    }
}
