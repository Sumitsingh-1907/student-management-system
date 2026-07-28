package com.sms.ui;

import com.sms.dao.StudentDAO;
import com.sms.model.Student;

import javax.swing.*;
import java.awt.*;

public class UpdateStudentFrame extends JFrame {

    private JTextField idField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JComboBox<String> genderBox;
    private JTextField ageField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField courseField;
    private JTextField addressField;

    public UpdateStudentFrame() {

        setTitle("Update Student");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(11, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        idField = new JTextField();
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        genderBox = new JComboBox<>(new String[]{"Male","Female","Other"});
        ageField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();
        courseField = new JTextField();
        addressField = new JTextField();

        JButton loadButton = new JButton("Load");
        JButton updateButton = new JButton("Update");
        JButton clearButton = new JButton("Clear");

        panel.add(new JLabel("Student ID"));
        panel.add(idField);

        panel.add(loadButton);
        panel.add(new JLabel(""));

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

        panel.add(updateButton);
        panel.add(clearButton);

        add(panel);

        loadButton.addActionListener(e -> loadStudent());
        updateButton.addActionListener(e -> updateStudent());
        clearButton.addActionListener(e -> clearFields());

        setVisible(true);
    }

    private void loadStudent() {

        try {

            int id = Integer.parseInt(idField.getText());

            StudentDAO dao = new StudentDAO();
            Student student = dao.getStudentById(id);

            if(student != null){

                firstNameField.setText(student.getFirstName());
                lastNameField.setText(student.getLastName());
                genderBox.setSelectedItem(student.getGender());
                ageField.setText(String.valueOf(student.getAge()));
                emailField.setText(student.getEmail());
                phoneField.setText(student.getPhone());
                courseField.setText(student.getCourse());
                addressField.setText(student.getAddress());

            }else{

                JOptionPane.showMessageDialog(this,"Student Not Found");

            }

        }catch(NumberFormatException e){

            JOptionPane.showMessageDialog(this,"Enter Valid Student ID");

        }

    }

    private void updateStudent() {

        try {

            Student student = new Student();

            student.setId(Integer.parseInt(idField.getText()));
            student.setFirstName(firstNameField.getText());
            student.setLastName(lastNameField.getText());
            student.setGender(genderBox.getSelectedItem().toString());
            student.setAge(Integer.parseInt(ageField.getText()));
            student.setEmail(emailField.getText());
            student.setPhone(phoneField.getText());
            student.setCourse(courseField.getText());
            student.setAddress(addressField.getText());

            StudentDAO dao = new StudentDAO();

            if(dao.updateStudent(student)){

                JOptionPane.showMessageDialog(this,"Student Updated Successfully!");

            }else{

                JOptionPane.showMessageDialog(this,"Update Failed!");

            }

        }catch(NumberFormatException e){

            JOptionPane.showMessageDialog(this,"Age and ID must be numbers.");

        }

    }

    private void clearFields(){

        idField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        genderBox.setSelectedIndex(0);
        ageField.setText("");
        emailField.setText("");
        phoneField.setText("");
        courseField.setText("");
        addressField.setText("");

        idField.requestFocus();

    }
}