package com.mkyong.common.entity;

import java.util.List;

/**
 * Created by dvetrov on 03/04/15.
 */

public class Fight {
    private List<User> users;

    public User getEnemy(User currentUser) {
        User enemy = null;
        for (User user : users) {
            if(!currentUser.equals(user)) {
                enemy = user;
            }
        }
        return enemy;
    }
}
