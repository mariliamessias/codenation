package br.com.curso.disciplinas;

import javax.persistence.EntityManager;
import java.util.List;

public class DisciplinaDAO {

    private EntityManager manager;

    public DisciplinaDAO(EntityManager manager){ this.manager = manager;}

    public List<Disciplina> findAll(){ return this.manager.createQuery("from disciplina").getResultList();}

    public void save(Disciplina disciplina){
        manager.getTransaction().begin();
        manager.persist(disciplina);
        manager.getTransaction().commit();
    }
}
