package br.com.curso.coordenador;

import br.com.curso.usuarios.repositorios.Usuario;

import javax.xml.bind.ValidationException;

public class Coordenador extends Usuario {
    private Long matricula;


    public Coordenador(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }
}
