package com.mkyong.common.controller;

import com.mkyong.common.entity.Project;
import com.mkyong.common.entity.User;
import com.mkyong.common.repository.ProjectRepository;
import com.mkyong.common.repository.UserRepository;
import com.mkyong.common.service.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/project")
public class ProjectController {
    @Autowired
    private UserSession userSession;

    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    protected ModelAndView getProjectPage(@PathVariable final long id) throws Exception {
        return new ModelAndView("project/show", new HashMap<String, Object>() {{
            put("project", projectRepository.getProject(id));
        }});
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    protected String saveProject(Project project) throws Exception {
        projectRepository.save(project);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    protected String deleteProject(Project project) throws Exception {
        projectRepository.delete(project);
        return "ok";
    }
}