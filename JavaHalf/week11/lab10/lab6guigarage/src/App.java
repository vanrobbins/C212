import java.awt.*;
import javax.swing.*;
public class App extends JFrame {
    public App() {
        super("Tom's Garage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.gray);
        //Elements
        AddVehicles addVPanel = new AddVehicles();
        ViewVehicles viewVPanel = new ViewVehicles();
        add(addVPanel);
        add(viewVPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new App();
            }
        });
    }
}
