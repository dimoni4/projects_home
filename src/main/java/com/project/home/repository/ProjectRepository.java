package com.project.home.repository;

import com.project.home.models.entity.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class ProjectRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Project project) {
        if (project.getId() != null && entityManager.find(Project.class, project.getId()) != null) {
            entityManager.merge(project);
        } else {
            entityManager.persist(project);
        }
    }

    public void delete(Project project) {
        project.setActive(false);
        save(project);
    }

    @Transactional(readOnly = true)
    public Project getProject(long id) {
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
