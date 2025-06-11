package org.example.finalprojectmodule3.service;

import org.example.finalprojectmodule3.dao.BookDAO;
import org.example.finalprojectmodule3.model.Book;

import java.util.List;

public class BookService {
    private BookDAO bookDAO = new BookDAO();

    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }

    public Book getBookById(String id) {
        return bookDAO.findById(id);
    }

    public void updateBookQuantity(String bookId, int changeAmount) {
        bookDAO.updateQuantity(bookId, changeAmount);
    }
}
