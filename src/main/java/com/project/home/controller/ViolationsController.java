package com.project.home.controller;

import com.project.home.entity.Violation;
import com.project.home.repository.ViolationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ViolationsController {
    @Autowired
    ViolationRepository violationRepository;

    @RequestMapping(value = "/project/violations/{projectId}")
    protected @ResponseBody List<Violation> showProjectPage(@PathVariable final long projectId) throws Exception {
        return violationRepository.findByProjectId(projectId);
    }
}