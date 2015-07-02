package com.mkyong.common.repository;

import com.mkyong.common.entity.Project;
import com.mkyong.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ProjectRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Project project) {
        if (project.getId() != null && entityManager.find(Project.class, project.getId()) != null) {
            entityManager.merge(project);
        } else {
            entityManager.persist(project);
        }
    }

    @Transactional
    public void delete(Project project) {
        project.setActive(false);
        save(project);
    }

    @Transactional(readOnly = true)
    public Project getProject(int id) {
        return entityManager.find(Project.class, id);
    }


    @Transactional(readOnly = true)
    public List<Project> getAllProjects() {
        try {
            return entityManager.createNamedQuery(Project.ALL, Project.class).getResultList();
        } catch (PersistenceException e) {
            return new ArrayList<Project>();
        }
    }

}
