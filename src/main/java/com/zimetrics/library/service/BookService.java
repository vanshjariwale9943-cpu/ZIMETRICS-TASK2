package com.zimetrics.library.service;

import com.zimetrics.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    private Map<Integer, Book> bookStorage = new HashMap<>();

    public Book addBook(Book book) {
        bookStorage.put(book.getId(), book);
        return book;
    }

    public Book getBookById(Integer id) {
        return bookStorage.get(id);
    }

    public List<Book> searchBooksByYear(Integer year) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookStorage.values()) {
            if (book.getYear().equals(year)) {
                result.add(book);
            }
        }
        return result;
    }

    public boolean deleteBook(Integer id) {
        if (bookStorage.containsKey(id)) {
            bookStorage.remove(id);
            return true;
        }
        return false;
    }
}
