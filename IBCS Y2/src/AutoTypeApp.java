import javax.swing.*;
import java.awt.*;

public class AutoTypeApp extends JFrame{
    JTextField inputField;
    JButton saveButton;
    JButton clearButton;

    public AutoTypeApp() {
        setTitle("Robot");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        inputField = new JTextField(20);
        saveButton = new JButton("Save");
        clearButton = new JButton("Clear");


        add(new JLabel("Message: "));
        add(inputField);
        add(saveButton);
        add(clearButton);


        setLocation(300,200);
        setVisible(true);
    }
}
