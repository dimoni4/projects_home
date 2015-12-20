package com.project.home.controller;

import com.project.home.models.entity.Instance;
import com.project.home.repository.InstanceRepository;
import com.project.home.repository.ProjectRepository;
import com.project.home.service.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/instance")
public class InstanceController {
    @Autowired
    private UserSession userSession;

    @Autowired
    InstanceRepository instanceRepository;

    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    protected ModelAndView showProjectPage(@PathVariable final long id) throws Exception {
        return new ModelAndView("instance/show", new HashMap<String, Object>() {{
            put("instance", instanceRepository.getInstance(id));
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    protected ModelAndView editProjectPage(@PathVariable final long id) throws Exception {
        return new ModelAndView("instance/edit", new HashMap<String, Object>() {{
            put("instance", instanceRepository.getInstance(id));
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    protected ModelAndView editProjectPageProcessor(@PathVariable final long id,
                                           @ModelAttribute final Instance instance) throws Exception {
        instance.setId(id);
        instanceRepository.save(instance);
        return new ModelAndView("instance/show", new HashMap<String, Object>() {{
            put("instance", instanceRepository.getInstance(instance.getId()));
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    protected ModelAndView createProjectPage() throws Exception {
        return new ModelAndView("instance/create", new HashMap<String, Object>() {{
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

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    protected String saveProject(Instance instance) throws Exception {
        instanceRepository.save(instance);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    protected String deleteProject(Instance instance) throws Exception {
        instanceRepository.delete(instance);
        return "ok";
    }
}