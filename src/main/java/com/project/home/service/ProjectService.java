package com.project.home.service;

import com.project.home.repository.ProjectRepository;
import com.project.home.repository.UserRepository;
import com.project.home.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
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
                        .add(new ProjectAccess(
                                vetrov,
                                testProject,
                                AccessType.OWNER))
                        .add(new Instance()
                                .setUrl("http://google.com")
                                .setCheckCreteria(CheckCreteria.SEARCH_WORD.setValue("google"))
                                .setStatus(Status.OK)
                                .setType(InstanceType.PRODUCTION)
                                .setDescription("trlolo")
                                .setProject(testProject))
        );
    }
}
