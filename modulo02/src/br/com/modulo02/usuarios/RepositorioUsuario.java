package br.com.modulo02.usuarios;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuario {
    private List<Usuario> usuarios = new ArrayList<>();

    public void add(Usuario usuario){
        this.usuarios.add( usuario );
    }

    public void remove(Usuario usuario){
        this.usuarios.remove(usuario);
    }

    public Usuario search(String nome){
        for(Usuario usuario : usuarios){
            if(usuario.getNome().equals(nome)){
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario>     findALl(){
        return this.usuarios;
    }
}
