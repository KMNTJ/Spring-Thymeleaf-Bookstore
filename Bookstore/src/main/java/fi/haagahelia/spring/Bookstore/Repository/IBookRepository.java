package fi.haagahelia.spring.Bookstore.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import fi.haagahelia.spring.Bookstore.Models.Book;

@RestResource
public interface IBookRepository extends CrudRepository<Book, Long>{
	
	List<Book> findByAuthor(String author);
	Book findByYear(@Param("year") String year);
	
	//void save(String author, String year, String isbn, String price);
}
