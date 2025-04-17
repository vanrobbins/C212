import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class App extends JFrame {
    public App() {
        super("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout(10, 10)); // Add spacing between components
        setSize(500, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.gray);

        // Elements
        InputCalc inputPanel = new InputCalc();
        OutputCalc outputPanel = new OutputCalc();
        JLabel name = new JLabel("Simple Calculator", SwingConstants.CENTER);
        JButton calculate = new JButton("Calculate");
        JButton clear = new JButton("Clear");

        ActionListener calcListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    // Get inputs from InputCalc
                    double num1 = Double.parseDouble(inputPanel.getFirstNumber());
                    double num2 = Double.parseDouble(inputPanel.getSecondNumber());
                    char operator = inputPanel.getOperator();

                    // Perform calculation
                    Calculate calc = new Calculate();
                    double result = calc.calculate(num1, num2, operator);

                    // Display result in InputCalc
                    inputPanel.setResult(result);

                    // Append the equation to the history in OutputCalc
                    String equation = num1 + " " + operator + " " + num2 + " = " + result;
                    outputPanel.appendHistory(equation);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException | ArithmeticException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Calculation Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        ActionListener clearListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                inputPanel.clearFields();
            }
        };

        calculate.addActionListener(calcListener);
        clear.addActionListener(clearListener);

        // Add padding to the main content
        JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPanel.setBackground(Color.gray);

        // Add components to the content panel
        contentPanel.add(name, BorderLayout.NORTH);
        contentPanel.add(inputPanel, BorderLayout.CENTER);
        contentPanel.add(outputPanel, BorderLayout.SOUTH);

        // Add buttons to a separate panel below OutputCalc
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(Color.gray);
        buttonPanel.add(calculate);
        buttonPanel.add(clear);

        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH); // Place buttons below OutputCalc

        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}
