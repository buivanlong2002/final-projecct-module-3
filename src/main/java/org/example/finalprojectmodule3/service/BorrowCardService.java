package org.example.finalprojectmodule3.service;

import org.example.finalprojectmodule3.dao.BorrowCardDAO;
import org.example.finalprojectmodule3.model.BorrowCard;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BorrowCardService {
    private BorrowCardDAO borrowCardDAO = new BorrowCardDAO();

    public List<BorrowCard> getAllCards() {
        return borrowCardDAO.findAll();
    }

    public List<BorrowCard> getAllBorrowingCards() {
        return borrowCardDAO.findAll()
                .stream()
                .filter(BorrowCard::isStatus) // status = true → đang mượn
                .collect(Collectors.toList());
    }

    public void returnBook(String cardId, Date date) {
        borrowCardDAO.returnBook(cardId);
    }

    public void addBorrowCard(BorrowCard card) {
        borrowCardDAO.save(card);
    }


}
