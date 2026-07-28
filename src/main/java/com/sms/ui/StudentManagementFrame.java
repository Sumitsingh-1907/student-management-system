package com.sms.ui;

import javax.swing.*;
import java.awt.*;

public class StudentManagementFrame extends JFrame {

    public StudentManagementFrame() {

        setTitle("Student Management");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel title = new JLabel("Student Management", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        JButton addButton = new JButton("Add Student");
        JButton viewButton = new JButton("View Students");
        JButton updateButton = new JButton("Update Student");
        JButton deleteButton = new JButton("Delete Student");

        // Button Actions
        addButton.addActionListener(e -> new AddStudentFrame());

        viewButton.addActionListener(e -> new ViewStudentsFrame());

        updateButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Update Student - Coming Soon"));

        deleteButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Delete Student - Coming Soon"));

        panel.add(title);
        panel.add(addButton);
        panel.add(viewButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        add(panel);

        setVisible(true);
    }
}