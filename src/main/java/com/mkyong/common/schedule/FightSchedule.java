package com.mkyong.common.schedule;

import com.mkyong.common.entity.Fight;
import com.mkyong.common.entity.FightStatus;
import com.mkyong.common.entity.User;
import com.mkyong.common.repository.FightRepository;
import com.mkyong.common.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Created by dvetrov on 08/04/15.
 */
@Component
public class FightSchedule {

    private static final Logger logger = LoggerFactory.getLogger("console");

    @Autowired
    FightRepository fightRepository;

    @Autowired
    UserRepository userRepository;

    @Scheduled(fixedDelay = 1000)
    public void startNewFights() {
        logger.error("START");
        List<User> usersWantFight = userRepository.getUserWantingFight();
        Collections.shuffle(usersWantFight);
        for(int i=0; i<usersWantFight.size(); i+=1) {
            Fight fight = new Fight();

            User user = usersWantFight.get(i);
            user.setFightStatus(FightStatus.FIGHT);
            user.setFight(fight);
            fightRepository.save(fight);
            userRepository.save(user);
        }


    }
}
