package com.sms.dao;

import com.sms.db.DBConnection;
import com.sms.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {

    public boolean addStudent(Student student) {

        String sql = "INSERT INTO students(first_name, last_name, gender, age, email, phone, course, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getGender());
            statement.setInt(4, student.getAge());
            statement.setString(5, student.getEmail());
            statement.setString(6, student.getPhone());
            statement.setString(7, student.getCourse());
            statement.setString(8, student.getAddress());

            int rows = statement.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}