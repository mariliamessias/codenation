package br.com.codenation.biblioteca.livro.model;

import br.com.codenation.biblioteca.avaliacao.model.Avaliacao;
import br.com.codenation.biblioteca.categoria.model.Categoria;

import javax.persistence.*;
import java.util.List;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String titulo;

    @OneToMany
    private List<Avaliacao> avaliacoes;

    @ManyToMany
    private List<Categoria> categorias;

    public Livro(String titulo){
        this.titulo = titulo;
    }

    public Livro(){
        super();
    }

}
