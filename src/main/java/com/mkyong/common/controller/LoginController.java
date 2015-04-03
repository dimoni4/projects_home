package com.mkyong.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	protected String loginPage() throws Exception {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	protected String processLogin() throws Exception {

		//TODO some login
		return "/index";
	}

}