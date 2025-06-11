package org.example.finalprojectmodule3.controller;

import org.example.finalprojectmodule3.model.Book;
import org.example.finalprojectmodule3.model.BorrowCard;
import org.example.finalprojectmodule3.model.Student;
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
    private final StudentService studentService = new StudentService();

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
        String cardId = request.getParameter("borrowId");
        String bookId = request.getParameter("bookId");
        String studentId = request.getParameter("studentId");
        String returnDateStr = request.getParameter("returnDate");

        LocalDate today = LocalDate.now();
        LocalDate returnDate = LocalDate.parse(returnDateStr);

        if (returnDate.isBefore(today)) {
            request.setAttribute("error", "Ngày trả phải sau hoặc bằng ngày mượn.");
            request.setAttribute("book", bookService.getBookById(bookId));
            request.setAttribute("students", studentService.getAllStudents());
            request.setAttribute("currentDate", today.toString());
            request.getRequestDispatcher("/borrow-form.jsp").forward(request, response);
            return;
        }


        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            request.setAttribute("error", "Học sinh không tồn tại.");
            request.setAttribute("book", bookService.getBookById(bookId));
            request.setAttribute("students", studentService.getAllStudents());
            request.setAttribute("currentDate", today.toString());
            request.getRequestDispatcher("/borrow-form.jsp").forward(request, response);
            return;
        }

        BorrowCard card = new BorrowCard();
        card.setId(cardId);
        card.setBook(bookService.getBookById(bookId));
        card.setStudent(student); // không để null!
        card.setBorrowDate(Date.valueOf(today));
        card.setReturnDate(Date.valueOf(returnDate));
        card.setStatus(true);

        borrowCardService.addBorrowCard(card);
        bookService.updateBookQuantity(bookId, -1);

        response.sendRedirect("borrow-cards");
    }

}
