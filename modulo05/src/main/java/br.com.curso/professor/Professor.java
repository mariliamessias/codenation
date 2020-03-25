package br.com.curso.professor;

import br.com.curso.disciplinas.Disciplina;
import br.com.curso.relatorios.Coluna;
import br.com.curso.usuarios.Usuario;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.bind.ValidationException;
import java.util.List;

@Entity
public class Professor extends Usuario {

    @OneToMany(mappedBy = "professor")
    private List<Disciplina> disciplinas;

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
