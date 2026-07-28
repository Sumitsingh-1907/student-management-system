package com.sms.ui;

import com.sms.dao.UserDAO;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {

        setTitle("Student Management System");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");

        panel.add(userLabel);
        panel.add(usernameField);

        panel.add(passLabel);
        panel.add(passwordField);

        panel.add(loginButton);
        panel.add(exitButton);

        add(panel);

        loginButton.addActionListener(e -> login());

        exitButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void login() {

        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        UserDAO dao = new UserDAO();

        if (dao.login(username, password)) {

            JOptionPane.showMessageDialog(this, "Login Successful!");

            dispose();

            new DashboardFrame();

        } else {

            JOptionPane.showMessageDialog(this, "Invalid Username or Password!");

        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(LoginFrame::new);

    }
}