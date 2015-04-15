package com.mkyong.common.controller;

import com.mkyong.common.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class LoginController {

	@ModelAttribute("user")
	public User populateForm() {
		return new User();
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	protected String loginPage() throws Exception {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	protected ModelAndView processLogin(@RequestParam String username,
								  @RequestParam String password,
								  @ModelAttribute User user) throws Exception {
		//TODO some login
		System.out.println("LOGIN: "+username);
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("user", new User(username));
		return mav;
	}

}