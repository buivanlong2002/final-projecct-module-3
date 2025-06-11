package org.example.finalprojectmodule3.dao;

import org.example.finalprojectmodule3.model.Book;
import org.example.finalprojectmodule3.model.BorrowCard;
import org.example.finalprojectmodule3.model.Student;
import org.example.finalprojectmodule3.util.DBUtil;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowCardDAO {
    private BookDAO bookDAO = new BookDAO();
    private StudentDAO studentDAO = new StudentDAO();

    public List<BorrowCard> findAll() {
        List<BorrowCard> list = new ArrayList<>();
        String sql = "SELECT * FROM borrow_cards ORDER BY borrow_date DESC";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Book book = bookDAO.findById(rs.getString("book_id"));
                Student student = studentDAO.findById(rs.getString("student_id"));
                BorrowCard card = new BorrowCard(
                        rs.getString("id"),
                        book,
                        student,
                        rs.getDate("borrow_date"),
                        rs.getDate("return_date"),
                        rs.getBoolean("status")
                );
                list.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void returnBook(String id) {
        String sql = "UPDATE borrow_cards SET return_date = CURDATE(), status = false WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(BorrowCard card) {
        String sql = "INSERT INTO borrow_cards(id, book_id, student_id, borrow_date, return_date, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, card.getId());
            stmt.setString(2, card.getBook().getId());
            stmt.setString(3, card.getStudent().getId());
            stmt.setDate(4, card.getBorrowDate());
            stmt.setDate(5, card.getReturnDate());
            stmt.setBoolean(6, card.isStatus());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
