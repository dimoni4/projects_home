package com.mkyong.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableScheduling
@Configuration
@Import({AppSecurityConfig.class, ViewConfig.class})
@ComponentScan({"com.mkyong.common.config",
        "com.mkyong.common.controller",
        "com.mkyong.common.repository",
        "com.mkyong.common.schedule"
})
public class RootConfig {


}