import javax.swing.*;
import java.awt.*;

// render GUI components (frontend)
public class PasswordGeneratorGUI extends JFrame {
    private final PasswordGenerator passwordGenerator;

    public PasswordGeneratorGUI(){
        super("Password Generator");

        setSize(548, 570);

        setResizable(false); // prevent GUI from resizing

        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null); // center GUI to the screen

        passwordGenerator = new PasswordGenerator();

        addGuiComponents();
    }

    private void addGuiComponents(){
        JLabel titleLabel = new JLabel("Password Generator");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 10, 540, 39);
        add(titleLabel);

        // result text area
        JTextArea passwordOutput = new JTextArea();
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));

        // horizontal scroll if too long
        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25, 97, 479, 70);

        // black border
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);

        // password length
        JLabel passwordLengthLabel = new JLabel("Password length: ");
        passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthLabel.setBounds(25, 215, 272, 39);
        add(passwordLengthLabel);

        // length input
        JTextArea passwordLengthInput = new JTextArea();
        passwordLengthInput.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthInput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInput.setBounds(310, 215, 192, 39);
        add(passwordLengthInput);

        // uppercase letter toggle
        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        uppercaseToggle.setBounds(25, 302, 225, 56);
        add(uppercaseToggle);

        // lowercase toggle
        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        lowercaseToggle.setBounds(282, 302, 225, 56);
        add(lowercaseToggle);

        // numbers toggle
        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        numbersToggle.setBounds(25, 373, 225, 56);
        add(numbersToggle);

        // symbols toggle
        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        symbolsToggle.setBounds(282, 373, 225, 56);
        add(symbolsToggle);

        // generate button
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        generateButton.setBounds(155, 477, 222, 41);
        generateButton.setBackground(Color.decode("#6EE3A5"));
        generateButton.addActionListener(e -> {
            if (passwordLengthInput.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Password length cannot be empty!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!passwordLengthInput.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

            boolean anyToggleSelected = lowercaseToggle.isSelected() ||
                    uppercaseToggle.isSelected() ||
                    numbersToggle.isSelected() ||
                    symbolsToggle.isSelected();

            int passwordLength = Integer.parseInt(passwordLengthInput.getText());
            if (anyToggleSelected) {
                String generatedPassword = passwordGenerator.generatePassword(passwordLength,
                        uppercaseToggle.isSelected(),
                        lowercaseToggle.isSelected(),
                        numbersToggle.isSelected(),
                        symbolsToggle.isSelected());

                passwordOutput.setText(generatedPassword);
            } else {
                JOptionPane.showMessageDialog(null, "Please select at least " +
                        "one toggle option!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(generateButton);
    }
}
