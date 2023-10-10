package com.example.GoodReades.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GoodReades.model.Book;

public interface BookJpaRepository extends JpaRepository<Book, Integer> {

	
		ArrayList<Book> getBooks();
		Book getBookById(int bookId);
		Book addBook(Book book);
		Book updateBook(int bookId, Book book);
		void deleteBook(int bookId);
}
