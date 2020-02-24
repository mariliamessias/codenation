package br.com.modulo02.disciplinas;

import br.com.modulo02.alunos.Aluno;
import br.com.modulo02.professor.Professor;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private List<Aluno> alunos = new ArrayList<>();
    private Professor professor;
    private static final byte LIMITE = 10;

    public Disciplina(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }

    public void matricular(Aluno aluno) throws LimiteAlunosAlcancadosException {
        if(this.alunos.size() < LIMITE){
            this.alunos.add(aluno);
        }else{
            throw new LimiteAlunosAlcancadosException("Limite de alunos alcançado. O limite é " + LIMITE);
        }
    }

    public void mostrarAlunos(){
        this.alunos.stream().forEach(aluno -> System.out.println(aluno.getNome()));
    }

}
