import java.awt.*;
import javax.swing.*;

public class seatwork1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Jerica's Swing App"); 
            frame.setSize(700, 420);                        
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            JLabel message = new JLabel("Hello Je! Welcome to my first Java Swing program!!!.", SwingConstants.CENTER);
            message.setFont(new Font("Arial", Font.PLAIN, 20));
            frame.add(message, BorderLayout.CENTER);

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
