package com.project.home.controller;

import com.project.home.service.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

	@Autowired
	private UserSession userSession;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	protected String loginPage() throws Exception {
		return "login";
	}
}