package br.com.curso;

import br.com.curso.alunos.Aluno;
import br.com.curso.alunos.dao.AlunoDAO;
import br.com.curso.disciplinas.Disciplina;
import br.com.curso.disciplinas.DisciplinaDAO;
import br.com.curso.disciplinas.LimiteAlunosAlcancadosException;
import br.com.curso.professor.Professor;
import br.com.curso.professor.ProfessorDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.ValidationException;

public class Main {

    public static void main(String[] args) throws ValidationException, LimiteAlunosAlcancadosException {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("curso");

        EntityManager manager = factory.createEntityManager();

        //Aluno

        AlunoDAO alunoDAO = new AlunoDAO(manager);

        Aluno aluno = new Aluno("login1", "401.822.758-25", "Teste aluno");

        alunoDAO.save(aluno);

        alunoDAO.findAll().forEach(a -> System.out.println(a.getNome()));

        alunoDAO.delete(aluno);

        alunoDAO.findAll().forEach(a -> System.out.println(a.getNome()));

        aluno.setNumeroMatricula(123);

        alunoDAO.findAll().forEach(a -> System.out.println(a.getNome()));

        //Professor

        ProfessorDAO professorDAO = new ProfessorDAO(manager);

        Professor professor = new Professor("loginProfessor", "401.822.758-25", "Professor 1");

        professorDAO.save(professor);

        professorDAO.findAll().forEach(p -> System.out.println(p.getNome()));

        //Disciplina

        DisciplinaDAO disciplinaDAO = new DisciplinaDAO(manager);

        Disciplina disciplina = new Disciplina("disciplina 1", professor);

        disciplinaDAO.save(disciplina);

        disciplinaDAO.findAll().forEach(d -> System.out.println(d.getNome()));

        disciplina.matricular(aluno);

        disciplinaDAO.save(disciplina);

        AlunoDAO.getAlunoPorDisciplina(disciplina).forEach(al -> System.out.println(aluno.getNome()));

        System.out.println("O aluno" + aluno.getNome() + "esta matriculado em: " + alunoDAO.getNumeroDisciplinaMatriculadas(aluno.getId()));

        factory.close();

    }
}
