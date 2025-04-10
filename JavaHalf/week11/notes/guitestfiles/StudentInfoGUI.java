/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package guitestfiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Student {
    String name, streetAddress, city, state, zipCode, level;

    public Student(String name, String streetAddress, String city, String state, String zipCode, String level) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', address='" + streetAddress + "', city='" + city +
               "', state='" + state + "', zipCode='" + zipCode + "', level='" + level + "'}";
    }
}

public class StudentInfoGUI extends JFrame {
    private final JTextField nameField, addressField, cityField, zipField;
    private final JComboBox<String> stateComboBox;
    private final ButtonGroup levelGroup;
    private final ArrayList<Student> studentList;

    public StudentInfoGUI() {
        studentList = new ArrayList<>();

        // Create and configure JFrame
        setTitle("Student Information");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2, 5, 5));

        // Name
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        // Street Address
        add(new JLabel("Street Address:"));
        addressField = new JTextField();
        add(addressField);

        // City
        add(new JLabel("City:"));
        cityField = new JTextField();
        add(cityField);

        // State (ComboBox)
        add(new JLabel("State:"));
        String[] states = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA",
                            "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
                            "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT",
                            "VA", "WA", "WV", "WI", "WY" };
        stateComboBox = new JComboBox<>(states);
        add(stateComboBox);

        // Zip Code
        add(new JLabel("Zip Code:"));
        zipField = new JTextField();
        add(zipField);

        // Level (Radio Buttons)
        add(new JLabel("Student Level:"));
        JPanel levelPanel = new JPanel(new FlowLayout());
        levelGroup = new ButtonGroup();
        JRadioButton seniorButton = new JRadioButton("Senior");
        JRadioButton juniorButton = new JRadioButton("Junior");
        JRadioButton sophomoreButton = new JRadioButton("Sophomore");
        JRadioButton freshmanButton = new JRadioButton("Freshman");
        levelGroup.add(seniorButton);
        levelGroup.add(juniorButton);
        levelGroup.add(sophomoreButton);
        levelGroup.add(freshmanButton);
        levelPanel.add(seniorButton);
        levelPanel.add(juniorButton);
        levelPanel.add(sophomoreButton);
        levelPanel.add(freshmanButton);
        add(levelPanel);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
        add(submitButton);

        // Display Button
        JButton displayButton = new JButton("Display All Students");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStudents();
            }
        });
        add(displayButton);

        setVisible(true);
    }

    private void addStudent() {
        String name = nameField.getText();
        String streetAddress = addressField.getText();
        String city = cityField.getText();
        String state = (String) stateComboBox.getSelectedItem();
        String zipCode = zipField.getText();
        String level = null;

        // Get selected radio button text
        for (AbstractButton button : java.util.Collections.list(levelGroup.getElements())) {
            if (button.isSelected()) {
                level = button.getText();
            }
        }

        if (name.isEmpty() || streetAddress.isEmpty() || city.isEmpty() || state.isEmpty() || zipCode.isEmpty() || level == null) {
            JOptionPane.showMessageDialog(this, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Add student to list
        Student student = new Student(name, streetAddress, city, state, zipCode, level);
        studentList.add(student);
        JOptionPane.showMessageDialog(this, "Student added successfully!");
    }

    private void displayStudents() {
        StringBuilder message = new StringBuilder("Student List:\n");
        for (Student student : studentList) {
            message.append(student).append("\n");
        }
        JOptionPane.showMessageDialog(this, message.toString(), "Student Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentInfoGUI::new);
    }
}

