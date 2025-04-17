import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class OutputCalc extends JPanel {
    private JTextArea historyArea;

    public OutputCalc() {
        TitledBorder addVBorder = BorderFactory.createTitledBorder("Histoy");
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);
        setBorder(addVBorder);
        // Create a text area for history
        historyArea = new JTextArea(10, 30);
        historyArea.setEditable(false); // Make it read-only
        JScrollPane scrollPane = new JScrollPane(historyArea); // Add scroll functionality

        // Add the text area to the panel
        add(scrollPane, BorderLayout.CENTER);
    }

    // Method to append a new equation to the history
    public void appendHistory(String equation) {
        historyArea.append(equation + "\n");
    }
}
