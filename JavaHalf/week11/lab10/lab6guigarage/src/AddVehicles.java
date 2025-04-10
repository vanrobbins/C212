import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
public class AddVehicles extends JPanel{
    public AddVehicles(){
        //Setting up Panel
        TitledBorder addVBorder = BorderFactory.createTitledBorder("Add Vehicle");
        setBounds(3,3,480,195);
        setLayout(new GridLayout(6,2,5,3));
        setBackground(Color.lightGray);
        setForeground(getBackground());
        setBorder(addVBorder);
        //Content
        JLabel type = new JLabel("Type:");
        JLabel make = new JLabel("Make:");
        JLabel model = new JLabel("Model:");
        JLabel year = new JLabel("Year:");
        JLabel mileage = new JLabel("Mileage:");

        String[] typesVehicles={"Car","Truck","Bike"};
        JComboBox<String> typeSelect = new JComboBox<String>(typesVehicles);
        JTextField makeInput = new JTextField();
        JTextField modelInput = new JTextField();
        JTextField yearInput = new JTextField();
        JTextField mileageInput = new JTextField();
        JButton addVehicleButton = new JButton("Add Vehicle");
        JButton clearFieldButton = new JButton("Clear Fields");
        //Styling
        JTextField[] textFields={makeInput,modelInput,yearInput,mileageInput};
        JButton[] bottons={addVehicleButton,clearFieldButton};
        for(JTextField textField:textFields){
            textField.setBackground(new Color(225,225,225));
            textField.setBorder(new LineBorder(Color.BLACK, 1));
            textField.setFont(new Font("Roboto", Font.PLAIN, 12));
            textField.setColumns(16);
        }
        for(JButton button:bottons){
            button.setBackground(new Color(225,225,225));
            button.setBorder(new LineBorder(Color.BLACK, 1));
        }
        typeSelect.setBackground(new Color(225,225,225));
        typeSelect.setBorder(new LineBorder(Color.black,1));
        typeSelect.setFocusable(false);
        //adding elements to Panel
        add(type);
        add(typeSelect);
        add(make);
        add(makeInput);
        add(model);
        add(modelInput);
        add(year);
        add(yearInput);
        add(mileage);
        add(mileageInput);
        add(addVehicleButton);
        add(clearFieldButton);
    }
}
