package com.example.GoodReades.service;

import com.example.GoodReades.model.Book;
import com.example.GoodReades.repository.BookJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookJpaService {

    @Autowired
    private BookJpaRepository bookJpaRepository;

    public ArrayList<Book> getBooks() {
        List<Book> bookList = bookJpaRepository.findAll();
        return new ArrayList<>(bookList);
    }

    public Book getBookById(int bookId) {
        try {
            return bookJpaRepository.findById(bookId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found with id: " + bookId));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }

    public Book addBook(Book book) {
        bookJpaRepository.save(book);
        return book;
    }

    public Book updateBook(int bookId, Book book) {
        try {
            Book existingBook = bookJpaRepository.findById(bookId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found with id: " + bookId));

            if (book.getName() != null) {
                existingBook.setName(book.getName());
            }
            if (book.getImgUrl() != null) {
                existingBook.setImgUrl(book.getImgUrl());
            }

            bookJpaRepository.save(existingBook);
            return existingBook;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }

    public void deleteBook(int bookId) {
        try {
            bookJpaRepository.deleteById(bookId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found with id: " + bookId);
        }
    }
}
