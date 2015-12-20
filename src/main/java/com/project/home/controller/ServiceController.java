package com.project.home.controller;

import com.project.home.models.entity.Instance;
import com.project.home.models.entity.Service;
import com.project.home.models.entity.Status;
import com.project.home.models.web.InstanceDTO;
import com.project.home.models.web.ServiceDTO;
import com.project.home.repository.InstanceRepository;
import com.project.home.repository.ProjectRepository;
import com.project.home.repository.ServiceRepository;
import com.project.home.service.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {
    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(value = "/edit/{serviceId}", method = RequestMethod.GET)
    protected ModelAndView editServicePage(@PathVariable final long serviceId) throws Exception {
        return new ModelAndView("service/edit", new HashMap<String, Object>() {{
            put("service", serviceRepository.getService(serviceId));
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/edit/{serviceId}", method = RequestMethod.POST)
    protected ModelAndView editServicePageProcessor(@PathVariable final long serviceId,
                                           @ModelAttribute final ServiceDTO serviceDTO) throws Exception {
        Service service = serviceRepository.getService(serviceId);
        service.setUrl(serviceDTO.getUrl());
        serviceRepository.save(service);
        return new ModelAndView("projects", new HashMap<String, Object>() {{
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    protected ModelAndView createServicePage() throws Exception {
        return new ModelAndView("service/create", new HashMap<String, Object>() {{
            put("projects", projectRepository.getAllProjects());
        }});
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    protected ModelAndView createServicePageProcessor(@ModelAttribute final Service service) throws Exception {
        serviceRepository.save(service);
        return new ModelAndView("projects", new HashMap<String, Object>() {{
            put("projects", projectRepository.getAllProjects());
        }});
    }
}