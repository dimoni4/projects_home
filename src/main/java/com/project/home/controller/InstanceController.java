package com.project.home.controller;

import com.project.home.models.entity.Instance;
import com.project.home.models.entity.Status;
import com.project.home.models.web.InstanceDTO;
import com.project.home.repository.InstanceRepository;
import com.project.home.repository.ProjectRepository;
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

    @RequestMapping(value = "/{instanceId}", method = RequestMethod.GET)
    protected ModelAndView showInstancePage(@PathVariable final long instanceId) throws Exception {
        return new ModelAndView("instance/show", new HashMap<String, Object>() {{
            put("instance", instanceRepository.getInstance(instanceId));
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/{instanceId}/edit", method = RequestMethod.GET)
    protected ModelAndView editInstancePage(@PathVariable final long instanceId) throws Exception {
        return new ModelAndView("instance/edit", new HashMap<String, Object>() {{
            put("instance", instanceRepository.getInstance(instanceId));
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/{instanceId}/edit", method = RequestMethod.POST)
    protected String editInstancePageProcessor(@PathVariable final long instanceId,
                                                     @PathVariable final long projectId,
                                           @ModelAttribute final InstanceDTO instanceDTO) throws Exception {
        Instance instance = instanceRepository.getInstance(instanceId);
        instance.setDescription(instanceDTO.getDescription());
        instance.setUrl(instanceDTO.getUrl());
        instanceRepository.save(instance);
        return "forward:/project/"+projectId;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    protected ModelAndView createInstancePage(@PathVariable final long projectId) throws Exception {
        return new ModelAndView("instance/create", new HashMap<String, Object>() {{
            put("project", projectRepository.getProject(projectId));
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    protected String createProjectPageProcessor(@ModelAttribute final Instance instance,
                                                      @PathVariable final long projectId) throws Exception {
        instance.setVersion("");
        instance.setStatus(Status.GOOD);
        instance.setProject(projectRepository.getProject(projectId));
        instanceRepository.save(instance);
        return "forward:/project/"+projectId;
    }
}