package br.com.codenation.biblioteca.livro.service;

import br.com.codenation.biblioteca.livro.model.Livro;
import br.com.codenation.biblioteca.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LivroServiceImpl implements  LivroService{
    
    @Autowired
    LivroRepository livroRepository;

    @Override
    public Livro save(Livro livro) {
       // preencherCategorias(livro);
        return this.livroRepository.save(livro);
    }

    @Override
    public Iterable<Livro> findAll() {
        return null;
    }

//    private void preencherCategorias(Livro livro) {
//    }
}
