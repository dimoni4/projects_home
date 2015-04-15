package com.mkyong.common.repository;

import javax.persistence.*;

import com.mkyong.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User save(User user) {
        //TODO encode password
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.persist(user);
        return user;
    }

    public User findByEmail(String email) {
        try {
            return entityManager.createNamedQuery(User.FIND_BY_EMAIL, User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (PersistenceException e) {
            return null;
        }
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    public List<User> getUserWantingFight() {
        return null;
    }
}
