package com.sms.ui;

import com.sms.dao.StudentDAO;
import com.sms.model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewStudentsFrame extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public ViewStudentsFrame() {

        setTitle("View Students");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columns = {
                "ID",
                "First Name",
                "Last Name",
                "Gender",
                "Age",
                "Email",
                "Phone",
                "Course",
                "Address"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        loadStudents();

        setVisible(true);
    }

    private void loadStudents() {

        StudentDAO dao = new StudentDAO();
        List<Student> students = dao.getAllStudents();

        model.setRowCount(0);

        for (Student s : students) {

            model.addRow(new Object[]{
                    s.getId(),
                    s.getFirstName(),
                    s.getLastName(),
                    s.getGender(),
                    s.getAge(),
                    s.getEmail(),
                    s.getPhone(),
                    s.getCourse(),
                    s.getAddress()
            });
        }
    }
}