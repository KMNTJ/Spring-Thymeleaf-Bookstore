package fi.haagahelia.spring.Bookstore.Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryId;
	private String name;
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="category")
	private List<Book> books;
	
	public Category(){
	}
	
	public Category(String name) {
		super();
		this.name = name;
		this.books = null;
	}


	public Category(String name, List<Book> books) {
		super();
		this.name = name;
		this.books = books;
	}

	public Category(Long id, String name) {
		super();
		this.categoryId = id;
		this.name = name;
		this.books = null;
	}

	public Category(Long id, String name, List<Book> books) {
		super();
		this.categoryId = id;
		this.name = name;
		this.books = books;
	}

	public Long getId() {
		return categoryId;
	}

	public void setId(Long id) {
		this.categoryId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Category [id=" + categoryId + ", name=" + name + "]";
	}
}







