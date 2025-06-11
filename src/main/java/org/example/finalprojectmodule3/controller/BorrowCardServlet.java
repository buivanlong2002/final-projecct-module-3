package org.example.finalprojectmodule3.controller;

import org.example.finalprojectmodule3.model.BorrowCard;
import org.example.finalprojectmodule3.service.BorrowCardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/borrow-cards")
public class BorrowCardServlet extends HttpServlet {
    private final BorrowCardService borrowCardService = new BorrowCardService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BorrowCard> borrowCards = borrowCardService.getAllBorrowingCards();
        request.setAttribute("borrowCards", borrowCards);
        request.getRequestDispatcher("/views/borrow-cards.jsp").forward(request, response);
    }
}
