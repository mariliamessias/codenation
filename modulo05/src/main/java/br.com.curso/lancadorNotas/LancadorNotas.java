package br.com.curso.lancadorNotas;


import br.com.curso.usuarios.UsuarioAutorizavel;

public class LancadorNotas {

    public void login(UsuarioAutorizavel usuarioAutorizavel){
        boolean temAutorizacao = usuarioAutorizavel.temAutorizacao();
        if(temAutorizacao){
            System.out.println("Usuario tem autorizacao");
        } else System.out.println("Não possui autorização");
    }
}
