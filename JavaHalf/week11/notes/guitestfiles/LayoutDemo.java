/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
*/

package guitestfiles;

import javax.swing.*;
import java.awt.*;

public class LayoutDemo extends JFrame {
    public LayoutDemo() {
        setTitle("Layout Manager Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2)); // Arrange each layout panel in a 3x2 grid

        // FlowLayout
        JPanel flowPanel = new JPanel(new FlowLayout());
        for (int i = 1; i <= 5; i++) {
            flowPanel.add(new JButton("Button " + i));
        }
        addPanel("FlowLayout", flowPanel);

        // BorderLayout
        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.add(new JButton("North"), BorderLayout.NORTH);
        borderPanel.add(new JButton("South"), BorderLayout.SOUTH);
        borderPanel.add(new JButton("East"), BorderLayout.EAST);
        borderPanel.add(new JButton("West"), BorderLayout.WEST);
        borderPanel.add(new JButton("Center"), BorderLayout.CENTER);
        addPanel("BorderLayout", borderPanel);

        // GridLayout
        JPanel gridPanel = new JPanel(new GridLayout(2, 3));
        for (int i = 1; i <= 5; i++) {
            gridPanel.add(new JButton("Button " + i));
        }
        addPanel("GridLayout", gridPanel);

        // BoxLayout
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
        for (int i = 1; i <= 5; i++) {
            boxPanel.add(new JButton("Button " + i));
            boxPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Add space between buttons
        }
        addPanel("BoxLayout", boxPanel);

        // CardLayout
        JPanel cardPanel = new JPanel(new CardLayout());
        for (int i = 1; i <= 5; i++) {
            cardPanel.add(new JButton("Card " + i), "Card " + i);
        }
        CardLayout cl = (CardLayout)(cardPanel.getLayout());
        cl.show(cardPanel, "Card 1"); // Show the first card initially
        addPanel("CardLayout", cardPanel);

        // GridBagLayout
        JPanel gridBagPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        for (int i = 1; i <= 5; i++) {
            gbc.gridx = i - 1;
            gbc.gridy = 0;
            gridBagPanel.add(new JButton("Button " + i), gbc);
        }
        addPanel("GridBagLayout", gridBagPanel);

        setSize(800, 600);
        setVisible(true);
    }

    private void addPanel(String title, JPanel panel) {
        panel.setBorder(BorderFactory.createTitledBorder(title));
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LayoutDemo());
    }
}
