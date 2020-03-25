package br.com.curso.usuarios.interfaces;

public interface UsuarioAuthorizavel {

    default boolean temAutorizacao() {
        return true;
    }

}
