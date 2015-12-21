package com.project.home.controller;

import com.project.home.models.entity.Project;
import com.project.home.models.web.ProjectDTO;
import com.project.home.repository.ProjectRepository;
import com.project.home.service.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/project")
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(value = "/{id}")
    protected ModelAndView showProjectPage(@PathVariable final long id) throws Exception {
        return new ModelAndView("project/show", new HashMap<String, Object>() {{
            put("project", projectRepository.getProject(id));
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    protected ModelAndView editProjectPage(@PathVariable final long id) throws Exception {
        return new ModelAndView("project/edit", new HashMap<String, Object>() {{
            put("project", projectRepository.getProject(id));
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/{projectId}/edit", method = RequestMethod.POST)
    protected ModelAndView editProjectPageProcessor(@PathVariable final long projectId,
                                           @ModelAttribute final ProjectDTO projectDTO) throws Exception {
        Project project = projectRepository.getProject(projectId);
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        projectRepository.save(project);

        return new ModelAndView("project/show", new HashMap<String, Object>() {{
            put("project", projectRepository.getProject(projectId));
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    protected ModelAndView createProjectPage() throws Exception {
        return new ModelAndView("project/create", new HashMap<String, Object>() {{
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    protected ModelAndView createProjectPageProcessor(@ModelAttribute final Project project) throws Exception {
        project.setActive(true);
        projectRepository.save(project);
        return new ModelAndView("project/show", new HashMap<String, Object>() {{
            put("project", projectRepository.getProject(project.getId()));
            put("projects", projectRepository.getAllProjects());
        }});
    }
}