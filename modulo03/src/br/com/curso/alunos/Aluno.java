package br.com.curso.alunos;

import br.com.curso.usuarios.repositorios.Usuario;

import javax.xml.bind.ValidationException;

public class Aluno extends Usuario {

    private Integer numeroMatricula;

    public Aluno(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
}
