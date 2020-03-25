package br.com.codenation.biblioteca.livro.repository;

import br.com.codenation.biblioteca.categoria.model.Categoria;
import br.com.codenation.biblioteca.livro.model.Livro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends CrudRepository<Livro, Long> {

    List<Livro> findAll();

    List<Livro> findByTitulo();

    List<Livro> findByTituloContaining();

    List<Livro> findByCategorias(Categoria categoria);

    @Query("from Livro livro where livro.categorias is not empty")
    List<Livro> findComCategoria();

    @Query(value = "select * from Livro livro " +
    " inner join livro.categoria cl  " +
    " on livro.id = cl.id.livro " +
    " inner join categoria c " +
    " on c.id = cl.id.categoria " +
    "where c.nome like %:nomeCategoria%", nativeQuery = true)
    List<Livro> findByNomeCategoria(@Param("nomeCategoria") String nomeCategoria);

}
