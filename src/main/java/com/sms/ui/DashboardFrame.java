package com.sms.ui;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {

        setTitle("Student Management System - Dashboard");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JLabel title = new JLabel("STUDENT MANAGEMENT SYSTEM", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JButton studentButton = new JButton("Student Management");
        JButton attendanceButton = new JButton("Attendance");
        JButton marksButton = new JButton("Marks");
        JButton reportButton = new JButton("Reports");
        JButton logoutButton = new JButton("Logout");

        panel.add(title);
        panel.add(studentButton);
        panel.add(attendanceButton);
        panel.add(marksButton);
        panel.add(reportButton);
        panel.add(logoutButton);

        add(panel);

        studentButton.addActionListener(e -> new StudentManagementFrame());

        logoutButton.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        setVisible(true);
    }
}