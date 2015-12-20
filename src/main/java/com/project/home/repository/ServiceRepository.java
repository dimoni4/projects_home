package com.project.home.repository;

import com.project.home.models.entity.Service;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
@Transactional
public class ServiceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Service Service) {
        if (Service.getId() != null && entityManager.find(Service.class, Service.getId()) != null) {
            entityManager.merge(Service);
        } else {
            entityManager.persist(Service);
        }
    }

    @Transactional(readOnly = true)
    public Service getService(long id) {
        return entityManager.find(Service.class, id);
    }
}
