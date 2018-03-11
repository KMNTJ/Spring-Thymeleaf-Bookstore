package fi.haagahelia.spring.Bookstore.WebControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.spring.Bookstore.Models.Book;
import fi.haagahelia.spring.Bookstore.Repository.IBookRepository;
import fi.haagahelia.spring.Bookstore.Repository.ICategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private IBookRepository iBookRepository;
	
	@Autowired
	private ICategoryRepository iCategoryRepository;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/listbooks", method=RequestMethod.GET)
	public String listBooks(Model model){
		model.addAttribute("books", iBookRepository.findAll());
		return "ListBook";
	}
	
	@RequestMapping(value="/addbook", method=RequestMethod.GET)
	public String addBook(Model model){
		model.addAttribute("book", new Book());
		model.addAttribute("categorylist", iCategoryRepository.findAll());
		return "AddBook";
	}
	
	@RequestMapping(value="/savebook", method=RequestMethod.POST)
	public String saveBook(Book book){
		iBookRepository.save(book);
		return "redirect:listbooks";
	}
	
	@RequestMapping(value="/editbook/{id}", method=RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model){
		model.addAttribute("book", iBookRepository.findOne(bookId));
		model.addAttribute("categorylist", iCategoryRepository.findAll());
		return "EditBook";
	}
	
	@RequestMapping(value="/deletebook/{id}", method=RequestMethod.GET)
	public String deleteBook(@PathVariable("id") String bookId, Model model){
		Long bookIdLong = null;
		try{
			bookIdLong = Long.parseLong(bookId);
			iBookRepository.delete(bookIdLong);
		}
		catch (Exception e){
		}
		return "redirect:../listbooks";
	}
	
}









