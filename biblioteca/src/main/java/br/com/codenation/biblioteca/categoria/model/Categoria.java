package br.com.codenation.biblioteca.categoria.model;

import br.com.codenation.biblioteca.livro.model.Livro;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @ManyToMany
    private List<Livro> livros;

}
