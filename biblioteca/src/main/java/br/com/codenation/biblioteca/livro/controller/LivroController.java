package br.com.codenation.biblioteca.livro.controller;

import br.com.codenation.biblioteca.livro.model.Livro;
import br.com.codenation.biblioteca.livro.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public Livro save(@RequestBody Livro livro){ return this.livroService.save(livro);}

    @GetMapping
    public Iterable<Livro> findAll(){ return this.livroService.findAll();}

//    @GetMapping("/{id}")
//    public Livro findById(@PathVariable("id") Long id ) { return this.livroService.findById(id).get();}


}
