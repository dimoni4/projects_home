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

    @Scheduled(fixedDelay = 30000)
    public void startNewFights() {
        logger.error("START");
        List<User> usersWantFight = userRepository.getUserWantingFight();
        Collections.shuffle(usersWantFight);
        for(int i=0; i<usersWantFight.size(); i+=2) {
            Fight fight = new Fight();
            fightRepository.save(fight);

            User user1 = usersWantFight.get(i);
            user1.setFightStatus(FightStatus.FIGHT);
            user1.setFight(fight);
            userRepository.save(user1);

            User user2 = usersWantFight.get(i+1);
            user2.setFightStatus(FightStatus.FIGHT);
            user2.setFight(fight);
            userRepository.save(user2);

            fight.addUser(user1).addUser(user2);
            fightRepository.save(fight);
        }


    }
}
