package com.project.home.schedule;

import com.project.home.service.InstanceCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class InstanceCheckScheduler {

    @Autowired
    private InstanceCheckService instanceCheckService;

    @Scheduled(fixedRate = 60000)
    public void checkInstances() {
        instanceCheckService.checkInstances();
    }
}
