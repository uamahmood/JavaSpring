package com.umermahmood.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.umermahmood.mvc.models.Book;
import com.umermahmood.mvc.services.BookService;

@RestController
public class BooksApi {
    private final BookService bookService;

	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	@RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
	 @RequestMapping(value="/api/books", method=RequestMethod.POST)
	    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
	        Book book = new Book(title, desc, lang, numOfPages);
	        return bookService.createBook(book);
	    }
	 @RequestMapping("/api/books/{id}")
	    public Book show(@PathVariable("id") Long id) {
	        Book book = bookService.findBook(id);
	        return book;
	    }
	 @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
		public Book Update(@PathVariable("id") Long id, 
				@RequestParam(value="title") String title, 
				@RequestParam(value="description") String description,
				@RequestParam(value="language") String language,
				@RequestParam(value="numPages") Integer numPages) {
			return bookService.updateBook(id, title, description, language, numPages);
		}
		@RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
		public void Delete(@PathVariable("id") Long id) {
			bookService.deleteBook(id);
		}
}
