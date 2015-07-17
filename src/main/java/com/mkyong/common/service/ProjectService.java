package com.mkyong.common.service;

import com.mkyong.common.entity.Project;
import com.mkyong.common.repository.ProjectRepository;
import com.mkyong.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @PostConstruct
    protected void initialize() {
        projectRepository.save(new Project().setName("Test1").setUrl("http://i.ua").setDescription("Best project"));
        projectRepository.save(new Project().setName("Test2").setUrl("http://google.com").setDescription("Just google"));
        projectRepository.save(new Project().setName("Test3").setUrl("http://i.ua").setDescription("Email service"));
    }
}
