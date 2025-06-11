package org.example.finalprojectmodule3.controller;

import org.example.finalprojectmodule3.model.Book;
import org.example.finalprojectmodule3.model.BorrowCard;
import org.example.finalprojectmodule3.service.BookService;
import org.example.finalprojectmodule3.service.BorrowCardService;
import org.example.finalprojectmodule3.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet("/borrow")
public class BorrowServlet extends HttpServlet {
    private final BorrowCardService borrowCardService = new BorrowCardService();
    private final BookService bookService = new BookService();
    private final StudentService studentService  = new StudentService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");
        if (bookId == null || bookId.isEmpty()) {
            response.sendRedirect("books");
            return;
        }

        Book book = bookService.getBookById(bookId);
        if (book == null) {
            response.sendRedirect("books");
            return;
        }

        request.setAttribute("book", book);
        request.setAttribute("students", studentService.getAllStudents());
        request.setAttribute("currentDate", LocalDate.now().toString());

        request.getRequestDispatcher("/borrow-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cardId = request.getParameter("cardId");
        String bookId = request.getParameter("bookId");
        String studentId = request.getParameter("studentId");
        String returnDateStr = request.getParameter("returnDate");

        BorrowCard card = new BorrowCard();
        card.setId(cardId);
        card.setBook(bookService.getBookById(bookId));
        card.setStudent(studentService.getStudentById(studentId));
        card.setBorrowDate(new Date(System.currentTimeMillis()));
        card.setReturnDate(Date.valueOf(returnDateStr));
        card.setStatus(true);
        borrowCardService.addBorrowCard(card);
        bookService.updateBookQuantity(bookId, -1);

        response.sendRedirect("borrow-cards");
    }
}
