package br.com.curso;

import br.com.curso.coordenador.Coordenador;
import br.com.curso.diretor.Diretor;
import br.com.curso.lancadorNotas.LancadorNotas;
import br.com.curso.professor.Professor;
import br.com.curso.usuarios.UsuarioAutorizavel;
import javax.xml.bind.ValidationException;

public class Main {

    public static void main(String[] args) throws ValidationException {
       UsuarioAutorizavel usuarioAutorizavel = new Professor("12344", "12345", "teste professor");
       new LancadorNotas().login(usuarioAutorizavel);

    }
}


