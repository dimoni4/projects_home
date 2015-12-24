package com.project.home.controller;

import com.project.home.models.entity.ViolationsEntry;
import com.project.home.repository.ViolationRepository;
import com.project.home.service.ViolationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/project/{projectId}/violation")
public class ViolationsController {
    @Autowired
    ViolationRepository violationRepository;

    @Autowired
    ViolationsService violationsService;

    @RequestMapping(value = "/chart")
    protected @ResponseBody List<ViolationsEntry> getViolationsByProject(@PathVariable final long projectId) throws Exception {
        return violationsService.violationsChartData(projectId);
    }

    @RequestMapping(value = "/{violationId}")
    protected @ResponseBody List<ViolationsEntry> getViolationsByProject(@PathVariable final long projectId,
                                                                         @PathVariable final long violationId) throws Exception {
        return violationRepository.getViolation(violationId);
    }
}