package com.project.home.controller;

import com.project.home.models.entity.Service;
import com.project.home.models.entity.Status;
import com.project.home.models.web.ServiceDTO;
import com.project.home.repository.ProjectRepository;
import com.project.home.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/project/{projectId}/service")
public class ServiceController {
    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(value = "/{serviceId}/edit", method = RequestMethod.GET)
    protected ModelAndView editServicePage(@PathVariable final long serviceId) throws Exception {
        return new ModelAndView("service/edit", new HashMap<String, Object>() {{
            put("service", serviceRepository.getService(serviceId));
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/{serviceId}/edit", method = RequestMethod.POST)
    protected String editServicePageProcessor(@PathVariable final long serviceId,
                                                    @PathVariable final long projectId,
                                           @ModelAttribute final ServiceDTO serviceDTO) throws Exception {
        Service service = serviceRepository.getService(serviceId);
        service.setUrl(serviceDTO.getUrl());
        serviceRepository.save(service);
        return "forward:/project/"+projectId;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    protected ModelAndView createServicePage(@PathVariable final long projectId) throws Exception {
        return new ModelAndView("service/create", new HashMap<String, Object>() {{
            put("project", projectRepository.getProject(projectId));
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    protected String createServicePageProcessor(@ModelAttribute final Service service,
                                                      @PathVariable final long projectId) throws Exception {
        service.setStatus(Status.OK);
        service.setProject(projectRepository.getProject(projectId));
        serviceRepository.save(service);
        return "forward:/project/"+projectId;
    }
}