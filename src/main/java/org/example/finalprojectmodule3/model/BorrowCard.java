package org.example.finalprojectmodule3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowCard {
    private String id;
    private Book book;
    private Student student;
    private Date borrowDate;
    private Date returnDate;
    private boolean status;
}
