package br.com.curso.professor;

import br.com.curso.relatorios.Coluna;
import br.com.curso.usuarios.repositorios.Usuario;

import javax.xml.bind.ValidationException;

public class Professor extends Usuario {

    String dataCargo;

    public Professor(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }

    @Coluna(posicao = 3, titulo = "Data do Cargo")
    public String getDataCargo() {
        return dataCargo;
    }

    public void setDataCargo(String dataCargo) {
        this.dataCargo = dataCargo;
    }
}
