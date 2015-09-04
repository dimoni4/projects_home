package com.project.home.controller;

import com.project.home.entity.ViolationsEntry;
import com.project.home.repository.ViolationRepository;
import com.project.home.service.ViolationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ViolationsController {
    @Autowired
    ViolationRepository violationRepository;

    @Autowired
    ViolationsService violationsService;

    @RequestMapping(value = "/project/violations/{projectId}")
    protected @ResponseBody List<ViolationsEntry> getViolationsByProject(@PathVariable final long projectId) throws Exception {
        return violationsService.violationsChartData(projectId);
    }

    @RequestMapping(value = "/project/violations")
    protected @ResponseBody List<ViolationsEntry> getAllViolations() throws Exception {
        return violationsService.violationsChartData();
    }
}