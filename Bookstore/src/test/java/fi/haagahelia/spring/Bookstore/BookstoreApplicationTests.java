package fi.haagahelia.spring.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.spring.Bookstore.WebControllers.AuthController;
import fi.haagahelia.spring.Bookstore.WebControllers.BookController;
import fi.haagahelia.spring.Bookstore.WebControllers.RestBookController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {

	@Autowired
	private AuthController authController;
	@Autowired
	private BookController bookController;
	@Autowired
	private RestBookController restBookController;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(authController).isNotNull();
		assertThat(bookController).isNotNull();
		assertThat(restBookController).isNotNull();
	}

}
