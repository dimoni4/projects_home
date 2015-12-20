package com.project.home.controller;

import com.project.home.models.entity.User;
import com.project.home.repository.UserRepository;
import com.project.home.service.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserSession userSession;

	@Autowired
	UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	protected User getUser(User user) throws Exception {
		return userRepository.getUser(user.getId());
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	protected String saveUser(User user) throws Exception {
		userRepository.save(user);
		return "ok";
	}
}