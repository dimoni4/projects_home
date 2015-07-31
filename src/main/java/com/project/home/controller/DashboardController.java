package com.project.home.controller;

import com.project.home.entity.User;
import com.project.home.repository.ProjectRepository;
import com.project.home.repository.UserRepository;
import com.project.home.service.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class DashboardController {

	@Autowired
	private UserSession userSession;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProjectRepository projectRepository;

	@RequestMapping("/dashboard")
	protected ModelAndView dashboardPage() throws Exception {
		ModelAndView model = new ModelAndView("dashboard");
		model.addObject("projects", projectRepository.getAllProjects());
		return model;
	}
}