package com.example.GoodReades.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.GoodReades.model.Book;

public class BookService {

		HashMap<Integer, Book> hmap = new HashMap<>();
		
		public BookService()
		{
			
			Book b1 = new Book(1, "harrypotter", "harrypotter.jpg");
			 Book b2=new Book(2,"Rise","rise.jpg");	
			 
			 hmap.put(b1.getId(), b1);
			 hmap.put(b2.getId(), b2);
			 
		}
		
		public ArrayList<Book>getBooks()
		{
			
			Collection<Book> bookCollection	= hmap.values();
			ArrayList<Book> books = new ArrayList<>(bookCollection);
			
			return books;
			
			
		}

			public Book getBookById(int bookId) {
				
				Book book = hmap.get(bookId);
				
				if(book==null) {
					
					 throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				}
				 return book;

			}
			public Book addBook(Book book) {
				
				int uniqueBookId =3;
				book.setId(uniqueBookId);
				 hmap.put(uniqueBookId, book);
				 uniqueBookId+=1;

				return  book;

			}
			
			public Book updateBook(int bookId, Book book) {
				
				Book existingBook = hmap.get(bookId);
				
				if(existingBook==null) {
					
					throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				}
				if(book.getName()!=null) {
					
					existingBook.setName(book.getName());
					
					
				}
				if(book.getImgUrl()!=null) {
					
					existingBook.setImgUrl(book.getImgUrl());
					
					
				}
				return existingBook;
				
			}
		
			public void deleteBook(int bookId) {
				
				Book book = hmap.get(bookId);
				if(book==null){
					
					 throw new ResponseStatusException(HttpStatus.NOT_FOUND);

				}
				else {
					 hmap.remove(bookId);
					 throw new ResponseStatusException(HttpStatus.NO_CONTENT);
				}
				
			}
}
