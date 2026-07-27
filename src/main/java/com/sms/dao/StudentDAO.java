package com.sms.dao;

import com.sms.db.DBConnection;
import com.sms.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Add Student
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

    // View All Students
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setGender(resultSet.getString("gender"));
                student.setAge(resultSet.getInt("age"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
                student.setCourse(resultSet.getString("course"));
                student.setAddress(resultSet.getString("address"));

                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}