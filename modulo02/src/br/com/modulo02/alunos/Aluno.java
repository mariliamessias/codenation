package br.com.modulo02.alunos;

import br.com.modulo02.usuarios.Usuario;

public class Aluno extends Usuario {

    private Integer numeroMatricula;

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public Aluno(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }

    public void imprimirDados(){
        System.out.println("Nome: " + super.getNome() + ", CPF: " + super.getCpf() );
    }

}
