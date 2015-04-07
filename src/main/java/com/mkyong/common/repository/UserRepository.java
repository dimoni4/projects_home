package com.mkyong.common.repository;

import com.mkyong.common.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by dvetrov on 03/04/15.
 */
@Repository
public class UserRepository {

    public void save(User user){

    }

    public void update(User user){

    }

    public User getUser(int id) {
        return new User();
    }

    public User getUser(String name) {
        return new User();
    }
}
