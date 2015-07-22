package com.project.home.schedule;

import com.project.home.service.InstanceCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class InstanceCheckScheduler {

    private static final Logger logger = LoggerFactory.getLogger(InstanceCheckScheduler.class);

    @Autowired
    private InstanceCheckService instanceCheckService;

    @Scheduled(fixedDelay = 60000)
    public void checkInstances() {
        logger.warn("checkInstances: START");
        instanceCheckService.checkInstances();
        logger.warn("checkInstances: STOP");
    }
}
