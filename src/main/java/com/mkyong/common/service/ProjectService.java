package com.mkyong.common.service;

import com.mkyong.common.entity.Project;
import com.mkyong.common.repository.ProjectRepository;
import com.mkyong.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.mkyong.common.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    protected void initialize() {
        User vetrov = new User("vetrovs@ua.fm", "123", "ROLE_USER");
        userRepository.save(vetrov);

        userRepository.save(new User("ilshyma", "123", "ROLE_USER"));
        userRepository.save(new User("admin", "admin", "ROLE_ADMIN"));

        projectRepository.save(new Project().setName("Test1").setUrl("http://i.ua").setDescription("Best project").setAuthor(vetrov));
        projectRepository.save(new Project().setName("Test2").setUrl("http://google.com").setDescription("Just google").setAuthor(vetrov));
        projectRepository.save(new Project().setName("Test3").setUrl("http://i.ua").setDescription("Email service").setAuthor(vetrov));
    }
}
