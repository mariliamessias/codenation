package challenge;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface QuoteRepository extends CrudRepository<Quote, Integer> {

    @Query(value = "SELECT * FROM Scripts ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Quote getQuote();

    @Query( value = "SELECT * FROM Scripts WHERE actor = :actor ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Quote getQuoteByActor(@Param("actor") String actor);

}
