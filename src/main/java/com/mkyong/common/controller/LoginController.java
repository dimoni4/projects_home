package com.mkyong.common.controller;

import com.mkyong.common.entity.User;
import com.mkyong.common.service.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Autowired
	private UserSession userSession;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	protected String loginPage() throws Exception {
		return "login";
	}
}