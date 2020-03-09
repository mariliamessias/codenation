package br.com.curso.diretor;

import br.com.curso.usuarios.UsuarioAutorizavel;


import javax.xml.bind.ValidationException;
import java.util.Arrays;
import java.util.List;

public class Diretor extends UsuarioAutorizavel {
    public Diretor(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }

    @Override
    protected List<String> getAutorizacoes() {
        return Arrays.asList("ADMIN");
    }

    @Override
    protected boolean verificarAutorizacaoLogin() {
        return true;
    }
}
