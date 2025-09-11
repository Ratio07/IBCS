import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class AutoTypeApp extends JFrame {
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


        saveButton.addActionListener(this::onSave);
        clearButton.addActionListener(e -> inputField.setText(""));

        setLocation(300, 200);
        setVisible(true);
    }

    public void onSave(ActionEvent e) {
        String text = inputField.getText();
        if(!text.trim().isEmpty()){
            try(FileWriter fw = new FileWriter("log.txt", true)){
                fw.write(LocalDateTime.now() + "| SAVED: " + text + "\n");
            } catch (Exception ignored){
                JOptionPane.showMessageDialog(this, "Saved: "+ text);
            }

        }
    }


    public static void main(String[] args) {
        new AutoTypeApp();
    }
}
