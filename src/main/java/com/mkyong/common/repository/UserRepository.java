package com.mkyong.common.repository;

import javax.persistence.*;

import com.mkyong.common.entity.FightStatus;
import com.mkyong.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.LinkedList;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User newUser(User user) {
        //TODO encode password
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.persist(user);
        return user;
    }

    @Transactional
    public void save(User user){
        if (user.getId() != null && entityManager.find(User.class, user.getId()) != null) {
            entityManager.merge(user);
        } else {
            entityManager.persist(user);
        }
    }

    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    @Transactional(readOnly = true)
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        try {
            return entityManager.createNamedQuery(User.FIND_BY_EMAIL, User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (PersistenceException e) {
            return null;
        }
    }

    @Transactional(readOnly = true)
    public List<User> getUserWantingFight() {
        try {
            return entityManager.createNamedQuery(User.FIND_BY_FIGHT_STATUS, User.class)
                    .setParameter("fightStatus", FightStatus.SEARCH)
                    .getResultList();
        } catch (PersistenceException e) {
            return new LinkedList<User>();
        }
    }
}
