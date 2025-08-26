import javax.swing.*;
import java.awt.*;

public class Test{

    public static void main(String[] args) {
        JLabel label = new JLabel();
        label.setText("shfoqiehfjia bauefouwqhe");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.add(label);
    }
}