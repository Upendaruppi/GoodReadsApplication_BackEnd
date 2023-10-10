package com.example.GoodReades.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.GoodReades.model.Book;
import com.example.GoodReades.model.BookRowMapper;
import com.example.GoodReades.repository.BookRepository;

@Service
public class BookMYSQLService {

	@Autowired
	private JdbcTemplate db;
	
	
	public ArrayList<Book>getBooks(){
		
		List<Book> bookList  = db.query("select *from book", new BookRowMapper());
		
		
		ArrayList<Book> books = new ArrayList<>(bookList);
		return books;
		
}
	
	public Book getBookById(int bookId) {
		
		try {
			
			Book book = db.queryForObject("select * from book where id = ?", new BookRowMapper(), bookId);
			
			return book;
			
		}catch(Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
	
	  public Book addBook(Book book)
	    {
	    	
	    	db.update("insert into book(name,imgUrl) values(?,?)",book.getName(),book.getImgUrl());
	    	Book savedBook=db.queryForObject("select * from book where name=? and imgUrl=?",new BookRowMapper(),book.getName(),book.getImgUrl());
	        return savedBook;
	        
	    	
	    }

	public Book updateBook(int bookId, Book book) {
		
		if(book.getName()!=null) {
		db.update("update book set name = ? where id =?", book.getName(), bookId);
	}
		
		
		
		if(book.getImgUrl()!=null)
	{
		db.update("update book set imgUrl=? where id=?", book.getImgUrl(),bookId);
	}
		
	return getBookById(bookId);
}
		public void deleteBook(int bookId) {
			
			db.update("delete from book"
					+ " where id = ?", bookId);
		}

	
	
}