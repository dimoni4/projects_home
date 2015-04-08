package com.mkyong.common.repository;

import com.mkyong.common.entity.Fight;
import com.mkyong.common.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by dvetrov on 03/04/15.
 */
@Repository
public class FightRepository {

    public void save(Fight Fight){

    }

    public Fight getFight(int id) {
        return new Fight();
    }

    public Fight getFight(User user) {
        return new Fight();
    }
}
