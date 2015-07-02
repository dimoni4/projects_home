package com.mkyong.common.controller;

import com.mkyong.common.entity.User;
import com.mkyong.common.repository.ProjectRepository;
import com.mkyong.common.repository.UserRepository;
import com.mkyong.common.service.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
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

	@RequestMapping(value = {"/", "/index"})
	protected ModelAndView indexPage(Principal principal) throws Exception {
		User user;
		if(userSession.getUserId() == null ){
			user = userRepository.findByEmail(principal.getName());
			userSession.setUserId(user.getId());
		} else {
			user = userRepository.getUser(userSession.getUserId());
		}


		ModelAndView model = new ModelAndView("index");
		model.addObject("user", user);
		model.addObject("projects", projectRepository.getAllProjects());
		return model;
	}
}