	package com.example.GoodReades.controller;
	import com.example.GoodReades.service.BookMYSQLService;
	import com.example.GoodReades.service.BookJpaService;

	import java.util.ArrayList;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;
	
	import com.example.GoodReades.model.Book;
	
	@RestController
	public class BookController {
	
		@Autowired
		  public BookJpaService bookJpaService;
		@GetMapping("/books")
		public ArrayList<Book>getBooks(){
			
			return bookJpaService.getBooks();
		}
		@GetMapping("/books/{bookId}")
		public Book getBookById(@PathVariable("bookId") int bookId)
		{
			return bookJpaService.getBookById(bookId);
		}
		
		@PostMapping("/books")
		public Book addBook(@RequestBody Book book){
			
			return bookJpaService.addBook(book);
		}
		@PutMapping("/books/{bookId}")
		public  Book updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book) {
			
			return bookJpaService.updateBook(bookId, book);
		}
		
	
			@DeleteMapping("books/{bookId}")
			public void deleteBook(@PathVariable("bookId") int bookId) {
				
				bookJpaService.deleteBook(bookId);
				
			}
	
	}