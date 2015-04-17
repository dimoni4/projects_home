package com.mkyong.common.controller;

import com.mkyong.common.entity.FightStatus;
import com.mkyong.common.entity.User;
import com.mkyong.common.repository.FightRepository;
import com.mkyong.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class SearchFightController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    FightRepository fightRepository;

    @RequestMapping(value = "/fight/search")
    protected String fightSearchStart(@ModelAttribute User session) throws Exception {
        User user = userRepository.findByEmail(session.getEmail());
        if (user.isInFight()) {
            return "forward:/fight";
        }
        if (!user.isWantFight()) {
            user.setFightStatus(FightStatus.SEARCH);
            userRepository.update(user);
        }
        if (userRepository.findByEmail(user.getEmail()).isInFight()) {
            return "fight";
        }
        return "searchfight";
    }

    @RequestMapping(value = "/fight/search/stop")
    protected String fightSearchStop(@ModelAttribute User user) throws Exception {
        user.setFightStatus(FightStatus.PEACE);
        userRepository.update(user);
        return "index";
    }

}