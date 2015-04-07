package com.mkyong.common.controller;

import com.mkyong.common.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected ModelAndView processLogin(@RequestParam String email,
								  @RequestParam String password,
								  @ModelAttribute User user) throws Exception {
		//TODO some login
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("user", new User(email));
		return mav;
	}

}