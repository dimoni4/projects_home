package com.project.home.controller;

import com.project.home.models.entity.Instance;
import com.project.home.models.web.InstanceDTO;
import com.project.home.repository.InstanceRepository;
import com.project.home.repository.ProjectRepository;
import com.project.home.service.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/project/{projectId}/instance")
public class InstanceController {
    @Autowired
    InstanceRepository instanceRepository;

    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    protected ModelAndView showInstancePage(@PathVariable final long id) throws Exception {
        return new ModelAndView("instance/show", new HashMap<String, Object>() {{
            put("instance", instanceRepository.getInstance(id));
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    protected ModelAndView editInstancePage(@PathVariable final long id) throws Exception {
        return new ModelAndView("instance/edit", new HashMap<String, Object>() {{
            put("instance", instanceRepository.getInstance(id));
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/edit/{instanceId}", method = RequestMethod.POST)
    protected ModelAndView editInstancePageProcessor(@PathVariable final long instanceId,
                                           @ModelAttribute final InstanceDTO instanceDTO) throws Exception {
        Instance instance = instanceRepository.getInstance(instanceId);
        instance.setDescription(instanceDTO.getDescription());
        instance.setUrl(instanceDTO.getUrl());
        instanceRepository.save(instance);
        return new ModelAndView("instance/show", new HashMap<String, Object>() {{
            put("instance", instanceRepository.getInstance(instanceId));
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    protected ModelAndView createInstancePage(@PathVariable final long projectId) throws Exception {
        return new ModelAndView("instance/create", new HashMap<String, Object>() {{
            put("project", projectRepository.getProject(projectId));
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    protected ModelAndView createProjectPageProcessor(@ModelAttribute final Instance instance) throws Exception {
        instanceRepository.save(instance);
        return new ModelAndView("instance/show", new HashMap<String, Object>() {{
            put("instance", instanceRepository.getInstance(instance.getId()));
            put("projects", projectRepository.getAllProjects());
        }});
    }
}