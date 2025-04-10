import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
public class ViewVehicles extends JPanel{
    public ViewVehicles(){
        TitledBorder viewVBorder = BorderFactory.createTitledBorder("Vehicles in Garage");
        setBounds(3,202,480,258);
        setBackground(Color.lightGray);
        setBorder(viewVBorder);
        JList<String> garageList = new JList<String>();
        JButton deleteVehicleButton = new JButton("Delete Selected Vehicle");
        //Styling
        Color element = new Color(225,225,225);
        garageList.setPreferredSize(new Dimension(470,197));
        deleteVehicleButton.setBackground(element);
        LineBorder line = new LineBorder(Color.BLACK, 1);
        EmptyBorder padding = new EmptyBorder(5, 15, 5, 15);
        deleteVehicleButton.setBorder(new CompoundBorder(line,padding));
        garageList.setBackground(element);
        garageList.setBorder(line);
        add(garageList);
        add(deleteVehicleButton);
    }
}
