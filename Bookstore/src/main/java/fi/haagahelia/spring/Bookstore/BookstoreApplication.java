package fi.haagahelia.spring.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.spring.Bookstore.Models.Book;
import fi.haagahelia.spring.Bookstore.Repository.IBookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookCommandLineRunner(IBookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("A", "B", "C", "D", "E"));
			repository.save(new Book("AA", "BB", "CC", "DD", "EE"));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
	
}
