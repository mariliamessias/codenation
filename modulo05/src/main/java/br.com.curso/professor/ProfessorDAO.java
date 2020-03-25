package br.com.curso.professor;

import javax.persistence.EntityManager;
import java.util.List;

public class ProfessorDAO {

    private EntityManager manager;

    public ProfessorDAO(EntityManager manager){ this.manager = manager; }

    public List<Professor> findAll(){ return this.manager.createQuery("from professor").getResultList();}

    public void save(Professor professor){
        manager.getTransaction().begin();
        manager.persist(professor);
        manager.getTransaction().commit();
    }
}
