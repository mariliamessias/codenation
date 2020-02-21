package br.com.modulo02;

import br.com.modulo02.alunos.Aluno;
import br.com.modulo02.alunos.ValidationException;

public class Main
{
    public static void main (String[] args) throws ValidationException {

        try {
            Aluno aluno = new Aluno("", "123", "344");
            aluno.imprimirDados();
        }
        catch (ValidationException e){
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }


    }
}
