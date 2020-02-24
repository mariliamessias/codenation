package br.com.modulo02.professor;

import br.com.modulo02.alunos.ValidationException;
import br.com.modulo02.usuarios.Usuario;

public class Professor extends Usuario {

    public Professor(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }
}
