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
public class IndexController {

	@Autowired
	private UserSession userSession;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProjectRepository projectRepository;

	@RequestMapping(value = {"/projects"})
	protected ModelAndView indexPage() throws Exception {
		ModelAndView model = new ModelAndView("projects");
		model.addObject("user", userRepository.getUser(userSession.getUserId()));
		model.addObject("projects", projectRepository.getAllProjects());
		return model;
	}

	@RequestMapping(value = {"/"})
	protected ModelAndView index(Principal principal) throws Exception {
		User user;
		if(userSession.getUserId() == null ){
			user = userRepository.findByEmail(principal.getName());
			userSession.setUserId(user.getId());
		} else {
			user = userRepository.getUser(userSession.getUserId());
		}


		ModelAndView model = new ModelAndView("projects");
		model.addObject("user", user);
		model.addObject("projects", projectRepository.getAllProjects());
		return model;
	}
}