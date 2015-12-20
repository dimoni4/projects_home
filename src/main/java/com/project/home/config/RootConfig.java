package com.project.home.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableWebSecurity
@EnableWebMvcSecurity
@EnableScheduling
@EnableAsync
@Configuration
@ComponentScan({
        "com.project.home.config",
        "com.project.home.controller",
        "com.project.home.repository",
        "com.project.home.models.entity",
        "com.project.home.schedule",
        "com.project.home.service"
})
public class RootConfig {


}