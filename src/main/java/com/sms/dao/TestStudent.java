package com.sms.dao;

import com.sms.model.Student;

public class TestStudent {

    public static void main(String[] args) {

        Student student = new Student();

        student.setFirstName("Sumit");
        student.setLastName("Singh");
        student.setGender("Male");
        student.setAge(21);
        student.setEmail("sumit@gmail.com");
        student.setPhone("9876543210");
        student.setCourse("Computer Science");
        student.setAddress("Ghaziabad");

        StudentDAO dao = new StudentDAO();

        if (dao.addStudent(student)) {
            System.out.println("Student Added Successfully!");
        } else {
            System.out.println("Failed to Add Student!");
        }
    }
}