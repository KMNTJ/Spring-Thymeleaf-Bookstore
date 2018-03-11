package fi.haagahelia.spring.Bookstore.Repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import fi.haagahelia.spring.Bookstore.Models.Category;

public interface ICategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findByName(String name);
}
