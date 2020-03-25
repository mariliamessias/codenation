package br.com.curso.disciplinas;

import br.com.curso.alunos.Aluno;
import br.com.curso.professor.Professor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Disciplina {

    private static final byte LIMITE = 10;

    @Id
    private Long id;
    private String nome;
    private String descricao;

    @ManyToMany
    @JoinTable(name = "disciplina_aluno", joinColumns =
            {@JoinColumn(name = "idDisciplina")}, inverseJoinColumns =
            {@JoinColumn(name = "idAluno")})
    private List<Aluno> alunos = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "idProfessor")
    private Professor professor;

    public Disciplina(String nome, Professor professor){
        this.nome = nome;
        this.professor = professor;
    }

    public void matricular(Aluno aluno) throws LimiteAlunosAlcancadosException {
        if(this.alunos.size() < LIMITE){
            this.alunos.add(aluno);
        }else{
            throw new LimiteAlunosAlcancadosException("Limite de alunos alcançado, o valor máximo é " + LIMITE);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
