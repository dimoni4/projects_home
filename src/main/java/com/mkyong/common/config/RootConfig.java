package com.mkyong.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableWebSecurity
@EnableWebMvcSecurity
@EnableScheduling
@Configuration
@ComponentScan({
        "com.mkyong.common.config",
        "com.mkyong.common.controller",
        "com.mkyong.common.repository",
        "com.mkyong.common.entity",
        "com.mkyong.common.schedule",
        "com.mkyong.common.service"
})
public class RootConfig {


}