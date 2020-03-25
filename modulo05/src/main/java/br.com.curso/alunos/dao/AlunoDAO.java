package br.com.curso.alunos.dao;

import br.com.curso.alunos.Aluno;
import br.com.curso.disciplinas.Disciplina;
import org.postgresql.core.NativeQuery;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

public class AlunoDAO {

    private static EntityManager manager;

    public AlunoDAO(EntityManager manager){this.manager = manager;}

    public void save(Aluno aluno){
        manager.getTransaction().begin();
        manager.persist(aluno);
        manager.getTransaction().commit();
    }

    public List<Aluno> findAll(){ return manager.createQuery("from Aluno").getResultList(); }

    public void delete(Aluno aluno){
        manager.getTransaction().begin();
        manager.remove(aluno);
        manager.getTransaction().commit();
    }

    public static List<Aluno> getAlunoPorDisciplina(Disciplina disciplina){
        Query query = manager.createQuery("from Aluno aluno" +
                "INNER JOIN FETCH aluno.disciplinas as disciplinas" +
                "where disciplina = ?1");
        query.setParameter(1, disciplina);
        return query.getResultList();
    }

    public BigInteger getNumeroDisciplinaMatriculadas(long idAluno){
        Query nativeQuery = manager.createNativeQuery( "select count(iddisciplina) \n + " +
                "from disciplina aluno \n" +
                "where idAluno = ?1;");
        nativeQuery.setParameter(1, idAluno);
        return (BigInteger) nativeQuery.getSingleResult();
    }

}
