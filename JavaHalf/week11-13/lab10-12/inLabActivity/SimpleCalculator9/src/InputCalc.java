import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class InputCalc extends JPanel {
    private JTextField first = new JTextField();
    private JTextField second = new JTextField();
    private String[] operators = {"+", "-", "/", "*"};
    private JComboBox<String> operatorBox = new JComboBox<>(operators);
    private JLabel result = new JLabel();

    InputCalc() {
        TitledBorder addVBorder = BorderFactory.createTitledBorder("Calculate");
        setLayout(new GridLayout(4, 2, 5, 3));
        setBackground(Color.lightGray);
        setForeground(getBackground());
        setBorder(addVBorder);

        // Adjust text field sizes
        first.setPreferredSize(new Dimension(100, 20));
        second.setPreferredSize(new Dimension(100, 20));

        JLabel firstLabel = new JLabel("First Number: ");
        JLabel secondLabel = new JLabel("Second Number: ");
        JLabel operatorLabel = new JLabel("Operator: ");
        JLabel resultLabel = new JLabel("Result: ");
        add(firstLabel);
        add(first);
        add(secondLabel);
        add(second);
        add(operatorLabel);
        add(operatorBox);
        add(resultLabel);
        add(result);
    }

    // Getter for the first number
    public String getFirstNumber() {
        return first.getText();
    }

    // Getter for the second number
    public String getSecondNumber() {
        return second.getText();
    }

    // Getter for the operator
    public char getOperator() {
        return operatorBox.getSelectedItem().toString().charAt(0);
    }

    // Setter for the result
    public void setResult(double value) {
        result.setText(String.valueOf(value));
    }

    // Clear all fields
    public void clearFields() {
        first.setText("");
        second.setText("");
        result.setText("");
        operatorBox.setSelectedIndex(0);
    }
}
