package br.com.codenation.biblioteca.leitor.model;

import br.com.codenation.biblioteca.avaliacao.model.Avaliacao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Leitor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    @OneToMany
    private List<Avaliacao> avaliacoes;

}
