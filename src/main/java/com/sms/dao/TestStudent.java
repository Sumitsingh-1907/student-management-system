package com.sms.dao;

import com.sms.model.Student;

import java.util.List;

public class TestStudent {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        // ============================
        // ADD STUDENT
        // ============================

        Student student = new Student();

        student.setFirstName("Rahul");
        student.setLastName("Sharma");
        student.setGender("Male");
        student.setAge(20);
        student.setEmail("rahul@gmail.com");
        student.setPhone("9876543210");
        student.setCourse("Computer Science");
        student.setAddress("Delhi");

        if (dao.addStudent(student)) {
            System.out.println("Student Added Successfully!");
        } else {
            System.out.println("Failed to Add Student!");
        }


        // ============================
        // VIEW STUDENTS
        // ============================

        System.out.println("\n----- Student List -----");

        List<Student> students = dao.getAllStudents();

        for (Student s : students) {

            System.out.println("ID : " + s.getId());
            System.out.println("Name : " + s.getFirstName() + " " + s.getLastName());
            System.out.println("Gender : " + s.getGender());
            System.out.println("Age : " + s.getAge());
            System.out.println("Email : " + s.getEmail());
            System.out.println("Phone : " + s.getPhone());
            System.out.println("Course : " + s.getCourse());
            System.out.println("Address : " + s.getAddress());
            System.out.println("----------------------------");
        }


        // ============================
        // UPDATE STUDENT
        // ============================

        Student updateStudent = new Student();

        updateStudent.setId(1);   // Change ID if needed
        updateStudent.setFirstName("Sumit");
        updateStudent.setLastName("Singh");
        updateStudent.setGender("Male");
        updateStudent.setAge(21);
        updateStudent.setEmail("sumit@gmail.com");
        updateStudent.setPhone("9999999999");
        updateStudent.setCourse("B.Tech CSE");
        updateStudent.setAddress("Ghaziabad");

        if (dao.updateStudent(updateStudent)) {
            System.out.println("\nStudent Updated Successfully!");
        } else {
            System.out.println("\nFailed to Update Student!");
        }


        // ============================
        // DELETE STUDENT
        // ============================

        int id = 2;   // Change ID if needed

        if (dao.deleteStudent(id)) {
            System.out.println("Student Deleted Successfully!");
        } else {
            System.out.println("Failed to Delete Student!");
        }

    }
}