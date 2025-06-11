package org.example.finalprojectmodule3.service;

import org.example.finalprojectmodule3.dao.StudentDAO;
import org.example.finalprojectmodule3.model.Student;

import java.util.List;

public class StudentService {
    private StudentDAO studentDAO = new StudentDAO();

    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    public Student getStudentById(String id) {
        return studentDAO.findById(id);
    }
}
