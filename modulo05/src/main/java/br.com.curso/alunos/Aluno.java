package br.com.curso.alunos;
import br.com.curso.disciplinas.Disciplina;
import br.com.curso.usuarios.UsuarioAutorizavel;

import javax.persistence.*;
import javax.xml.bind.ValidationException;
import java.util.List;

@Entity
public class Aluno extends UsuarioAutorizavel {

    private Integer numeroMatricula;

    @ManyToMany
    @JoinTable( name = "disciplina_aluno", joinColumns =
            {@JoinColumn( name = "idAluno")}, inverseJoinColumns =
            {@JoinColumn( name = "idDisciplina")})
    private List<Disciplina> disciplinas;

    public Aluno(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }

    @Override
    protected List<String> getAutorizacoes() {
        return null;
    }

    @Override
    protected boolean verificarAutorizacaoLogin() {
        return false;
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
}
