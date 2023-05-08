package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecryptionView extends JFrame {

    private final JTextField keyField;
    private final JTextField encryptedTextField;
    private final JTextField decryptedTextField;
    private final JButton decryptButton;

    public DecryptionView() {
        setTitle("Decryption Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        // Set window icon
        ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"/"+"resources/image-icon.png");
        setIconImage(icon.getImage());

        JLabel keyLabel = new JLabel("Key:");
        keyField = new JTextField();
        JLabel encryptedTextLabel = new JLabel("Encrypted Text:");
        encryptedTextField = new JTextField();
        JLabel decryptedTextLabel = new JLabel("Decrypted Text:");
        decryptedTextField = new JTextField();
        decryptedTextField.setEditable(false);

        decryptButton = new JButton("Decrypt");
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firePropertyChange("DecryptButtonClicked", null, null);
            }
        });

        panel.add(keyLabel);
        panel.add(keyField);
        panel.add(encryptedTextLabel);
        panel.add(encryptedTextField);
        panel.add(decryptedTextLabel);
        panel.add(decryptedTextField);

        add(panel, BorderLayout.CENTER);
        add(decryptButton, BorderLayout.SOUTH);
        setVisible(true);
    }

    public String getKey() {
        return keyField.getText();
    }

    public String getEncryptedText() {

        return encryptedTextField.getText();
    }

    public void setDecryptedText(String decryptedText) {
        decryptedTextField.setText(decryptedText);
    }

    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}