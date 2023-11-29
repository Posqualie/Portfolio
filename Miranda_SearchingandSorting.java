import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Miranda_SearchingandSorting extends JFrame {

    private final Set<Integer> numberSet = new LinkedHashSet<>();
    private final JTextArea resultTextArea;

    public Miranda_SearchingandSorting() {
        setTitle("Number Manipulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Input components
        JTextField numberInput = new JTextField();
        JButton addButton = new JButton("Add Number");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber(numberInput.getText());
            }
        });

        // Control buttons
        JButton sortButton = new JButton("Sort");
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortNumbers();
            }
        });

        JButton shuffleButton = new JButton("Shuffle");
        shuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shuffleNumbers();
            }
        });

        JButton reverseButton = new JButton("Reverse");
        reverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reverseNumbers();
            }
        });

        // Result text area
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);

        // Adding components to the frame
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(numberInput);
        inputPanel.add(addButton);

        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.add(sortButton);
        controlPanel.add(shuffleButton);
        controlPanel.add(reverseButton);

        add(inputPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.CENTER);
        add(new JScrollPane(resultTextArea), BorderLayout.SOUTH);
    }

    private void addNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            numberSet.add(number);
            updateResult();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void sortNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numberSet);
        Collections.sort(sortedNumbers);
        updateResult(sortedNumbers);
    }

    private void shuffleNumbers() {
        List<Integer> shuffledNumbers = new ArrayList<>(numberSet);
        Collections.shuffle(shuffledNumbers);
        updateResult(shuffledNumbers);
    }

    private void reverseNumbers() {
        List<Integer> reversedNumbers = new ArrayList<>(numberSet);
        Collections.reverse(reversedNumbers);
        updateResult(reversedNumbers);
    }

    private void updateResult() {
        updateResult(new ArrayList<>(numberSet));
    }

    private void updateResult(List<Integer> numbers) {
        StringBuilder result = new StringBuilder();
        for (Integer number : numbers) {
            result.append(number).append(" ");
        }
        resultTextArea.setText(result.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Miranda_SearchingandSorting().setVisible(true);
            }
        });
    }
}
