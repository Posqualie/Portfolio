import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChangeApp {
    private JFrame frame;
    private JPanel centerPanel;

    public ColorChangeApp() {
        // Create the main frame
        frame = new JFrame("Color Change App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create buttons with icons
        JButton redButton = new JButton("Red", new ImageIcon("red.png"));
        JButton greenButton = new JButton("Green", new ImageIcon("green.png"));
        JButton blueButton = new JButton("Blue", new ImageIcon("blue.png"));

        // Create the center panel
        centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);

        // Add action listeners to the buttons
        redButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerPanel.setBackground(Color.RED);
            }
        });

        greenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerPanel.setBackground(Color.GREEN);
            }
        });

        blueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerPanel.setBackground(Color.BLUE);
            }
        });

        // Add buttons to a panel at the top
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(redButton);
        buttonPanel.add(greenButton);
        buttonPanel.add(blueButton);

        // Add components to the main frame
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        // Set frame properties
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ColorChangeApp();
            }
        });
    }
}
