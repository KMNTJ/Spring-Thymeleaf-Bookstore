package fi.haagahelia.spring.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.spring.Bookstore.Models.Book;
import fi.haagahelia.spring.Bookstore.Models.Category;
import fi.haagahelia.spring.Bookstore.Repository.IBookRepository;
import fi.haagahelia.spring.Bookstore.Repository.ICategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookCommandLineRunner(IBookRepository bookRepository, ICategoryRepository categoryRepository) {
		return (args) -> {
			log.info("create a couple of categories");
			categoryRepository.save(new Category("Horror"));
			categoryRepository.save(new Category("SciFi"));
			
			log.info("save a couple of books");
			bookRepository.save(new Book("A", "B", "C", "D", "E", categoryRepository.findByName("Horror").get(0)));
			bookRepository.save(new Book("AA", "BB", "CC", "DD", "EE", categoryRepository.findByName("SciFi").get(0)));
			
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
	
}
