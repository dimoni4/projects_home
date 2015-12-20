package com.project.home.service;

import com.project.home.repository.ProjectRepository;
import com.project.home.repository.UserRepository;
import com.project.home.models.entity.*;
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


        projectRepository.save(
                new Project()
                        .setName("Test1")
                        .setDescription("Best project")
                        .setActive(true)
                        .add(new Access(
                                vetrov,
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
                                .setUrl("http://i.ua")
                                .setStatus(Status.OK))
        );

        projectRepository.save(
                new Project()
                        .setName("Testw")
                        .setDescription("Best project")
                        .setActive(true)
                        .add(new Access(
                                vetrov,
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
                                .setUrl("http://i.ua")
                                .setStatus(Status.OK))
        );

        projectRepository.save(
                new Project()
                        .setName("Test3")
                        .setDescription("Best project")
                        .setActive(true)
                        .add(new Access(
                                vetrov,
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
                                .setUrl("http://i.ua")
                                .setStatus(Status.OK))
        );
        projectRepository.save(
                new Project()
                        .setName("Test4")
                        .setDescription("Best project")
                        .setActive(true)
                        .add(new Access(
                                vetrov,
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
                                .setUrl("http://i.ua")
                                .setStatus(Status.OK))
                        .add(new Service()
                                .setType(Service.Type.SONAR)
                                .setUrl("http://i.ua")
                                .setStatus(Status.OK))
        );
    }
}
