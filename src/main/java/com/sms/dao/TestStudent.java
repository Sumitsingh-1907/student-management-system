package com.sms.dao;

import com.sms.model.Student;

import java.util.List;

public class TestStudent {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        List<Student> students = dao.getAllStudents();

        for (Student student : students) {

            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Gender: " + student.getGender());
            System.out.println("Age: " + student.getAge());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Phone: " + student.getPhone());
            System.out.println("Course: " + student.getCourse());
            System.out.println("Address: " + student.getAddress());

            System.out.println("--------------------------------");
        }
    }
}