package br.com.curso;

import br.com.curso.alunos.Aluno;
import br.com.curso.credito.AnalisadorCredito;
import br.com.curso.credito.externo.Pessoa;
import br.com.curso.relatorios.GeradorRelatorio;
import br.com.curso.usuarios.repositorios.Usuario;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ValidationException {

        GeradorRelatorio geradorRelatorio = new GeradorRelatorio();
        Usuario usuario = new Aluno("aluno", "123", "aluno teste");
        Usuario usuario1 = new Aluno("aluno1", "123", "aluno teste");
        Usuario usuario2 = new Aluno("aluno2", "123", "aluno teste");
        List<Object> usuarios = new ArrayList<>();
        usuarios.add(usuario);
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        geradorRelatorio.gerarRelatorio(usuarios, 2);

        /*
        -- aula de reflections
        Pessoa pessoa = getPessoa();
        AnalisadorCredito analisadorCredito = new AnalisadorCredito();
        boolean resultado = analisadorCredito.analisarCredito(pessoa);
        if(resultado) System.out.println("Crédito aprovado");
        else System.out.println("Crédito reprovado");
        */
    }

    private static Pessoa getPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Pessoa teste");
        pessoa.setCpf("123");
        pessoa.setQtdeChequesDevolvidos(0);
        pessoa.setScoreSerasa(500);
        pessoa.setSocreSpc(500);
        pessoa.setValorDivida(1000);
        return pessoa;

    }
}
