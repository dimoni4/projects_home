package com.mkyong.common.controller;

import com.mkyong.common.entity.User;
import com.mkyong.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class SearchFightController {
	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/fight/search")
	protected String fightSearchStart(@ModelAttribute User user) throws Exception {
		user.setWantFight(true);
		userRepository.update(user);
		return "searchfight";
	}

	@RequestMapping(value = "/fight/search/stop")
	protected String fightSearchStop(@ModelAttribute User user) throws Exception {
		user.setWantFight(false);
		userRepository.update(user);
		return "index";
	}

}