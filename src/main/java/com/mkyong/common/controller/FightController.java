package com.mkyong.common.controller;

import com.mkyong.common.entity.Fight;
import com.mkyong.common.entity.User;
import com.mkyong.common.repository.FightRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class FightController {
	FightRepository fightRepository;
	@RequestMapping(value = "/fight", method = RequestMethod.POST)
	protected ModelAndView indexPage(@ModelAttribute User user) throws Exception {
		Fight fight = fightRepository.getFight(user);

		ModelAndView model = new ModelAndView("index");
		model.addObject("user", user);
		model.addObject("enemy", fight.getEnemy(user));
		model.addObject("fight", fight);

		return model;
	}

}