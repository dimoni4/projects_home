package com.project.home.controller;

import com.project.home.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = {"/public"})
public class PublicController {

    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(value = {"/project/all"})
    protected ModelAndView indexPage() throws Exception {
        ModelAndView model = new ModelAndView("public/project/all");
        model.addObject("projects", projectRepository.getAllProjects());
        return model;
    }
}