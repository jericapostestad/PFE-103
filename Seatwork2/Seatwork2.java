import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.*;

public class Seatwork2 {
    private static final NumberFormat MONEY = NumberFormat.getCurrencyInstance(Locale.US);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Seatwork2::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Tip Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(430, 280);
        frame.setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(18, 20, 18, 20));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8, 8, 8, 8);
        c.fill = GridBagConstraints.HORIZONTAL;

        JTextField billField = new JTextField(15);
        JTextField tipField = new JTextField(15);
        JButton calculateButton = new JButton("Calculate Tip");
        JLabel resultLabel = new JLabel("Enter bill and tip percentage.");
        resultLabel.setForeground(new Color(35, 85, 145));

        c.gridx = 0; c.gridy = 0; panel.add(new JLabel("Bill amount:"), c);
        c.gridx = 1; panel.add(billField, c);
        c.gridx = 0; c.gridy = 1; panel.add(new JLabel("Tip percentage (%):"), c);
        c.gridx = 1; panel.add(tipField, c);
        c.gridx = 0; c.gridy = 2; c.gridwidth = 2; panel.add(calculateButton, c);
        c.gridy = 3; panel.add(resultLabel, c);

        calculateButton.addActionListener(e -> {
            try {
                double bill = Double.parseDouble(billField.getText().trim());
                double tipPercent = Double.parseDouble(tipField.getText().trim());

                if (!Double.isFinite(bill) || !Double.isFinite(tipPercent)
                        || bill < 0 || tipPercent < 0) {
                    resultLabel.setForeground(Color.RED);
                    resultLabel.setText("Please enter valid non-negative numb.");
                    return;
                }

                double tip = bill * (tipPercent / 100.0);
                double total = bill + tip;
                resultLabel.setForeground(new Color(20, 110, 55));
                resultLabel.setText(String.format("Tip: %s     Total: %s", MONEY.format(tip), MONEY.format(total)));
            } catch (NumberFormatException ex) {
                resultLabel.setForeground(Color.RED);
                resultLabel.setText("Invalid input. Please enter numbers for both.");
            }
        });

        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
