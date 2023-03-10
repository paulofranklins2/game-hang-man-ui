import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangMan extends JFrame implements ActionListener {

    private JLabel guessingWordLabel;
    private JLabel missingLettersLabel;
    private JTextField inputTextField;
    private JButton submitButton;
    private JButton restartButton;
    private JPanel mainPanel;

    private Scanner scanner;
    private char input;
    private int missingLetter;
    private char[] guessingWord;
    private String[] split;

    private ArrayList<String> listOfWords;

    public HangMan() {
        super("Guess the Word");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setResizable(false);
        setLocationRelativeTo(null);

        scanner = new Scanner(System.in);

        guessingWordLabel = new JLabel();
        guessingWordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        guessingWordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        guessingWordLabel.setVerticalAlignment(SwingConstants.CENTER);
        guessingWordLabel.setPreferredSize(new Dimension(300, 50));
        guessingWordLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        missingLettersLabel = new JLabel();
        missingLettersLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        missingLettersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        missingLettersLabel.setVerticalAlignment(SwingConstants.CENTER);
        missingLettersLabel.setPreferredSize(new Dimension(300, 20));

        inputTextField = new JTextField();
        inputTextField.setPreferredSize(new Dimension(150, 30));
        inputTextField.addActionListener(this);

        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 30));
        submitButton.addActionListener(this);
        submitButton.setBorder(BorderFactory.createEmptyBorder());

        restartButton = new JButton("Restart");
        restartButton.setPreferredSize(new Dimension(100, 30));
        restartButton.addActionListener(this);
        restartButton.setBorder(BorderFactory.createEmptyBorder());

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(guessingWordLabel, BorderLayout.NORTH);
        mainPanel.add(missingLettersLabel, BorderLayout.CENTER);
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputTextField, BorderLayout.WEST);
        inputPanel.add(submitButton, BorderLayout.CENTER);
        inputPanel.add(restartButton, BorderLayout.EAST);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        add(mainPanel);

        startGame();
    }

    public void startGame() {
        listOfWords = new ArrayList<>(Arrays.asList("chair", "table", "plant", "books", "phone", "clock", "chair", "light", "shoes", "gloves", "guitar", "pizza", "watch", "radio", "coins", "knife", "spoon", "forks", "paper", "penis", "pants", "shirt", "dress", "shark", "sushi", "tooth", "brush", "lamps", "boots", "shirt", "mouse", "globe", "piano", "wallet", "purse", "bagel", "bread", "juice", "coffee", "timer", "brush", "soaps", "soapz", "sugar", "sauce", "salad", "burger", "fries", "candy", "apple", "grape", "lemon", "pills", "hatzz", "capes", "rings", "watch", "towel", "soapz", "toile", "tacos", "teeth", "brush", "water", "purse", "books", "tapes", "tapes", "paste", "cream", "phone", "chair", "glass", "clock", "watch", "chair", "table", "plate", "spoon", "forks", "knife", "bowlz", "coats", "gloves", "fries", "burger", "pizza", "sushi", "sugar", "sauce", "salad", "boots", "shoes", "dress", "shirt", "pants", "paper"));
        int randomWord = new Random().nextInt(listOfWords.size());

        String word = listOfWords.get(randomWord);
        split = word.split("");
        guessingWord = new char[word.length()];
        Arrays.fill(guessingWord, '_');
        missingLetter = word.length();

        updateUI();
    }

    public void updateUI() {
        guessingWordLabel.setText(new String(guessingWord));
        missingLettersLabel.setText("Missing Letters: " + missingLetter);
        inputTextField.setText("");
        inputTextField.requestFocus();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton || e.getSource() == inputTextField) {
            String inputStr = inputTextField.getText().trim().toUpperCase();
            if (inputStr.length() != 1 || !Character.isLetter(inputStr.charAt(0))) {
                JOptionPane.showMessageDialog(this, "Invalid Input. Please enter a single letter.");
            } else {
                input = inputStr.charAt(0);
                boolean letterFound = false;
                for (int i = 0; i < split.length; i++) {
                    if (split[i].equalsIgnoreCase(String.valueOf(input)) && guessingWord[i] == '_') {
                        guessingWord[i] = input;
                        missingLetter--;
                        letterFound = true;
                    }
                }
                if (!letterFound) {
                    JOptionPane.showMessageDialog(this, "Letter not found!");
                }
                if (missingLetter == 0) {
                    // Draw the last letter on the UI before showing "You win" window
                    for (int i = 0; i < guessingWord.length; i++) {
                        if (guessingWord[i] == '_') {
                            guessingWord[i] = split[i].charAt(0);
                            break;
                        }
                    }
                    updateUI();
                    JOptionPane.showMessageDialog(this, "You win!");
                    startGame();
                } else {
                    updateUI();
                }
            }
        } else if (e.getSource() == restartButton) {
            startGame();
        }
    }
}