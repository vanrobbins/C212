/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

 package guitestfiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUIExample {
    public static void main(String[] args) {
        // Step 1: Create the frame (window)
        JFrame frame = new JFrame("Simple GUI Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Using no layout manager for simplicity

        // Step 2: Create components (label and button)
        JLabel label = new JLabel("Hello, World!");
        label.setBounds(100, 50, 100, 30); // Set position and size

        JButton button = new JButton("Click Me");
        button.setBounds(100, 100, 100, 30);

        // Step 3: Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(label.getText()+"1");
            }
        });

        // Step 4: Add components to the frame
        frame.add(label);
        frame.add(button);

        // Step 5: Make the frame visible
        frame.setVisible(true);
    }
}
