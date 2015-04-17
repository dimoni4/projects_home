package com.mkyong.common.repository;

import com.mkyong.common.entity.Fight;
import com.mkyong.common.entity.FightStatus;
import com.mkyong.common.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dvetrov on 03/04/15.
 */
@Repository
public class FightRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Fight fight){
        if (fight.getId() != null && entityManager.find(Fight.class, fight.getId()) != null) {
            entityManager.merge(fight);
        } else {
            entityManager.persist(fight);
        }
    }

    @Transactional(readOnly = true)
    public Fight getFight(int id) {
        return entityManager.find(Fight.class, id);
    }

    @Transactional(readOnly = true)
    public Fight getFight(User user) {
        try {
            return entityManager.createNamedQuery(Fight.FIND_BY_USER, Fight.class)
                    .setParameter("user", user)
                    .getSingleResult();
        } catch (PersistenceException e) {
            return null;
        }
    }
}
