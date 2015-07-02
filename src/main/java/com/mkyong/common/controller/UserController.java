package com.mkyong.common.controller;

import com.mkyong.common.entity.Project;
import com.mkyong.common.entity.User;
import com.mkyong.common.repository.ProjectRepository;
import com.mkyong.common.repository.UserRepository;
import com.mkyong.common.service.UserSession;
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