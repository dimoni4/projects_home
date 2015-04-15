package com.mkyong.common.schedule;

import com.mkyong.common.entity.Fight;
import com.mkyong.common.entity.FightStatus;
import com.mkyong.common.entity.User;
import com.mkyong.common.repository.FightRepository;
import com.mkyong.common.repository.UserRepository;
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
    @Autowired
    FightRepository fightRepository;

    @Autowired
    UserRepository userRepository;

    @Scheduled(cron = "*/60 * * * * *")
    public void startNewFights() {
        System.out.println("Start figths!");
        List<User> usersWantFight = userRepository.getUserWantingFight();
        Collections.shuffle(usersWantFight);
        for(int i=0; i<usersWantFight.size(); i+=1) {
            Fight fight = new Fight();

            User user = usersWantFight.get(i);
            user.setFightStatus(FightStatus.FIGHT);

            fight.addUser(user).addUser(user);
            fightRepository.save(fight);

            userRepository.save(user);
        }

//        for(int i=0; i<usersWantFight.size(); i+=2) {
//            Fight fight = new Fight();
//
//            User user1 = usersWantFight.get(i);
//            user1.setFightStatus(FightStatus.FIGHT);
//            User user2 = usersWantFight.get(i);
//            user2.setFightStatus(FightStatus.FIGHT);
//
//            fight.addUser(user1).addUser(user2);
//            fightRepository.save(fight);
//
//            userRepository.save(user1);
//            userRepository.save(user2);
//        }
    }
}
