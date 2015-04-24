package com.mkyong.common.controller;

import com.mkyong.common.entity.Fight;
import com.mkyong.common.entity.User;
import com.mkyong.common.repository.FightRepository;
import com.mkyong.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class FightController {
	@Autowired
	UserRepository userRepository;

	@Autowired
	FightRepository fightRepository;

	@RequestMapping(value = "/fight")
	protected ModelAndView indexPage(@ModelAttribute User session) throws Exception {
		User user = userRepository.findByEmail(session.getEmail());
		Fight fight = user.getFight();

		ModelAndView model = new ModelAndView("fight");
		model.addObject("user", user);
		model.addObject("enemy", fight.getEnemy(user));
		model.addObject("fight", fight);

		return model;
	}

	@RequestMapping(value = "/fight/action")
	protected ModelAndView fightAction(@ModelAttribute User session) throws Exception {
		User user = userRepository.findByEmail(session.getEmail());
		Fight fight = user.getFight();

		ModelAndView model = new ModelAndView("fight");
		model.addObject("user", user);
		model.addObject("enemy", fight.getEnemy(user));
		model.addObject("fight", fight);

		return model;
	}

}