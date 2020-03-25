package br.com.curso.usuarios;

import br.com.curso.usuarios.repositorios.Usuario;

import javax.xml.bind.ValidationException;
import java.util.List;

public abstract class UsuarioAutorizavel extends Usuario {

    public UsuarioAutorizavel(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }

    public boolean temAutorizacao(){

        List<String> autorizacoes = getAutorizacoes();
        return autorizacoes.contains("ADMIN") || verificarAutorizacaoLogin();
    }

    protected abstract List<String> getAutorizacoes();
    protected abstract boolean verificarAutorizacaoLogin();

}
