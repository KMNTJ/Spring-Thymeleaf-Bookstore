package fi.haagahelia.spring.Bookstore.WebControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.spring.Bookstore.Models.Book;
import fi.haagahelia.spring.Bookstore.Repository.IBookRepository;

@RestController
public class RestBookController{
	
	@Autowired
	private IBookRepository iBookRepository;
	
	@RequestMapping(value="api/listbooks", method=RequestMethod.GET)
	public List<Book> showBookListRest(){
		//Cast the return into the according type
		return (List<Book>)iBookRepository.findAll();
	}
	
	@RequestMapping(value="api/showbook/{id}", method=RequestMethod.GET)
	public Book showBookRest(@PathVariable("id") Long id){
		//Cast the return into the according type
		return iBookRepository.findOne(id);
	}
	
	//Rikki todennäköisesti useasta kohtaa. Herjaa 405. "Request method 'Get' not supported"
	@RequestMapping(value="api/addbook/{author, year, isbn, price, category}", method=RequestMethod.POST)
	public List<Book> addBookRest(@PathVariable("author") String author, 
							@PathVariable("year") String year,
							@PathVariable("isbn") String isbn, 
							@PathVariable("price") String price,
							@PathVariable("category") String category){
		Book book = new Book(author, year, isbn, price, category);
		iBookRepository.save(book);
		//Cast the return into the according type
		return (List<Book>)iBookRepository.findAll();
	}
	
}












