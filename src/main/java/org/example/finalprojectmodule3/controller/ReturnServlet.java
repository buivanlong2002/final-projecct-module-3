package org.example.finalprojectmodule3.controller;

import org.example.finalprojectmodule3.service.BookService;
import org.example.finalprojectmodule3.service.BorrowCardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/return")
public class ReturnServlet extends HttpServlet {
    private final BorrowCardService borrowCardService = new BorrowCardService();
    private final BookService bookService = new BookService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cardId = request.getParameter("cardId");
        String bookId = request.getParameter("bookId");

        borrowCardService.returnBook(cardId, new Date(System.currentTimeMillis()));
        bookService.updateBookQuantity(bookId, 1);

        response.sendRedirect("borrow-cards");
    }
}
