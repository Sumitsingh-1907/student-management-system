package com.sms.ui;

import com.sms.dao.StudentDAO;
import com.sms.model.Student;

import javax.swing.*;
import java.awt.*;

public class AddStudentFrame extends JFrame {

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JComboBox<String> genderBox;
    private JTextField ageField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField courseField;
    private JTextField addressField;

    public AddStudentFrame() {

        setTitle("Add Student");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(9, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        firstNameField = new JTextField();
        lastNameField = new JTextField();
        genderBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        ageField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();
        courseField = new JTextField();
        addressField = new JTextField();

        JButton saveButton = new JButton("Save");
        JButton clearButton = new JButton("Clear");

        panel.add(new JLabel("First Name"));
        panel.add(firstNameField);

        panel.add(new JLabel("Last Name"));
        panel.add(lastNameField);

        panel.add(new JLabel("Gender"));
        panel.add(genderBox);

        panel.add(new JLabel("Age"));
        panel.add(ageField);

        panel.add(new JLabel("Email"));
        panel.add(emailField);

        panel.add(new JLabel("Phone"));
        panel.add(phoneField);

        panel.add(new JLabel("Course"));
        panel.add(courseField);

        panel.add(new JLabel("Address"));
        panel.add(addressField);

        panel.add(saveButton);
        panel.add(clearButton);

        add(panel);

        // Button Actions
        saveButton.addActionListener(e -> saveStudent());
        clearButton.addActionListener(e -> clearFields());

        setVisible(true);
    }

    private void saveStudent() {

        try {

            Student student = new Student();

            student.setFirstName(firstNameField.getText().trim());
            student.setLastName(lastNameField.getText().trim());
            student.setGender(genderBox.getSelectedItem().toString());
            student.setAge(Integer.parseInt(ageField.getText().trim()));
            student.setEmail(emailField.getText().trim());
            student.setPhone(phoneField.getText().trim());
            student.setCourse(courseField.getText().trim());
            student.setAddress(addressField.getText().trim());

            StudentDAO dao = new StudentDAO();

            if (dao.addStudent(student)) {

                JOptionPane.showMessageDialog(this,
                        "Student Added Successfully!");

                clearFields();

            } else {

                JOptionPane.showMessageDialog(this,
                        "Failed to Add Student!");

            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "Age must be a valid number!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    "Error: " + e.getMessage());

            e.printStackTrace();
        }
    }

    private void clearFields() {

        firstNameField.setText("");
        lastNameField.setText("");
        genderBox.setSelectedIndex(0);
        ageField.setText("");
        emailField.setText("");
        phoneField.setText("");
        courseField.setText("");
        addressField.setText("");

        firstNameField.requestFocus();
    }
}