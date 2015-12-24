package com.project.home.repository;

import com.project.home.models.entity.Violation;
import com.project.home.models.entity.ViolationsEntry;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.LinkedList;
import java.util.List;


@Repository
public class ViolationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Violation> findByInstanceId(final long  instanceId) {
        try {
            return entityManager.createNamedQuery(Violation.FIND_BY_INSTANCE_ID, Violation.class)
                    .setParameter("instanceId", instanceId)
                    .getResultList();
        } catch (PersistenceException e) {
            return new LinkedList<Violation>();
        }
    }

    @Transactional(readOnly = true)
    public List<Violation> findByProjectId(final long projectId) {
        try {
            return entityManager.createNamedQuery(Violation.FIND_BY_PROJECT_ID, Violation.class)
                    .setParameter("projectId", projectId)
                    .getResultList();
        } catch (PersistenceException e) {
            return new LinkedList<Violation>();
        }
    }

    @Transactional(readOnly = true)
    public List<Violation> findAll() {
        try {
            return entityManager.createNamedQuery(Violation.FIND_ALL, Violation.class)
                    .getResultList();
        } catch (PersistenceException e) {
            return new LinkedList<Violation>();
        }
    }

    @Transactional(readOnly = true)
    public ViolationsEntry getViolation(long violationId) {
        return entityManager.find(ViolationsEntry.class, violationId);
    }
}
