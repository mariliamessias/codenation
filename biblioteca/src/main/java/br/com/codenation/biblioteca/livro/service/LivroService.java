package br.com.codenation.biblioteca.livro.service;

import br.com.codenation.biblioteca.livro.model.Livro;

public interface LivroService {
    public Livro save(Livro livro);

    public Iterable<Livro> findAll();
}
