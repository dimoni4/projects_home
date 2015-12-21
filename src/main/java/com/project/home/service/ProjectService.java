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
                        .setName("ОЧ - В интернете")
                        .setDescription("Интернет Оплата частями")
                        .setActive(true)
                        .add(new Access(
                                vetrov,
                                Access.Type.OWNER))
                        .add(new Instance()
                                .setUrl("https://payparts2.privatbank.ua/ipp/")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "предлагаем"))
                                .setStatus(Status.OK)
                                .setType(Instance.Type.PRODUCTION)
                                .setDescription("боевой инстанс")
                                .setVersion("2.102"))
                        .add(new Instance()
                                .setUrl("https://brtp.test.it.loc/ipp/")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "предлагаем"))
                                .setStatus(Status.OK)
                                .setType(Instance.Type.TEST)
                                .setDescription("тестовый инстанс")
                                .setVersion("2.371"))
                        .add(new Instance()
                                .setUrl("https://brtp-stage.test.it.loc/ipp/")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "предлагаем"))
                                .setStatus(Status.OK)
                                .setType(Instance.Type.STAGE)
                                .setDescription("предрелиз")
                                .setVersion("2.105"))
                        .add(new Service()
                                .setType(Service.Type.JENKINS)
                                .setUrl("http://10.1.98.135:8000/view/Applications/job/pp_internet/")
                                .setStatus(Status.OK))
                        .add(new Service()
                                .setType(Service.Type.SONAR)
                                .setUrl("http://10.1.98.135:8001/dashboard/index?id=pp_internet")
                                .setStatus(Status.OK))
                        .add(new Service()
                                .setType(Service.Type.LOG)
                                .setUrl("http://10.1.109.51:9000/apache-tomcat-payparts2.privatbank.ua/pp_internet/")
                                .setStatus(Status.OK))
        );

        projectRepository.save(
                new Project()
                        .setName("ОЧ - Автозаведение")
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
                        .setName("Эквайринг - Мои торговые точки")
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
                        .setName("Страхование - Физ лица")
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
