package com.project.home.repository;

import com.project.home.entity.Instance;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class InstanceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Instance instance) {
        if (instance.getId() != null && entityManager.find(Instance.class, instance.getId()) != null) {
            entityManager.merge(instance);
        } else {
            entityManager.persist(instance);
        }
    }

    @Transactional(readOnly = true)
    public Instance getInstance(long id) {
        return entityManager.find(Instance.class, id);
    }
}
