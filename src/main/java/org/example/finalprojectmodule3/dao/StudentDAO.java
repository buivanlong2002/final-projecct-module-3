package org.example.finalprojectmodule3.dao;

import org.example.finalprojectmodule3.model.Student;
import org.example.finalprojectmodule3.util.DBUtil;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("student_class")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student findById(String id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("student_class")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
