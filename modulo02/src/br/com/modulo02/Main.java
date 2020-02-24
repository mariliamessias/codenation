package br.com.modulo02;

import br.com.modulo02.alunos.Aluno;
import br.com.modulo02.alunos.ValidationException;
import br.com.modulo02.disciplinas.Disciplina;
import br.com.modulo02.disciplinas.LimiteAlunosAlcancadosException;
import br.com.modulo02.professor.Professor;
import br.com.modulo02.usuarios.RepositorioUsuario;

public class Main
{
    public static void main (String[] args) {

//        try {
//            Aluno aluno = new Aluno("", "123", "344");
//            aluno.imprimirDados();
//        }
//        catch (ValidationException e){
//            System.out.println("Message: " + e.getMessage());
//            e.printStackTrace();
//        }

        /*Exemplo de herança**/
//        try{
//            Professor professor = new Professor("professor", "123", "Silvano");
//            Disciplina disciplina = new Disciplina("Matematica", professor);
//            for(int i = 1; i <=15; i++){
//                disciplina.matricular(new Aluno("aluno", "1234", "Silva " + i));
//            }
//            disciplina.mostrarAlunos();
//        }catch (ValidationException | LimiteAlunosAlcancadosException e){
//            System.out.println(e.getMessage());
//        }

    /* Exemplo de polimorfismo*/
        RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
        try{
            Professor professor = new Professor("professor", "123", "Silvano");
            Aluno aluno = new Aluno("aluno2", "2222", "mol");
            repositorioUsuario.add(professor);
            repositorioUsuario.add(aluno);
            repositorioUsuario.findALl().stream().forEach(System.out::println);
        }catch (ValidationException e){
            System.out.println(e.getMessage());
        }



    }
}
