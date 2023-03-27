package Frame;

import Main.Cipher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame{
    JPanel MainPanel;
    private JTextField textFieldKey;
    private JTextField textFieldOrg;
    private JTextField textFieldEncr;
    private JButton encryptButton;
    private JButton decryptButton;
    private JLabel keyLabel, OrgTextLabel, encrTextLabel;

    Cipher action = new Cipher();

    public Window() {
        initialize();
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encryptText();
            }
        });
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decryptText();
            }
        });
    }

    public void initialize(){
        setTitle("Vigenere cipher");
        add(MainPanel);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void encryptText(){
        String orgText = textFieldOrg.getText();
        String key = action.generateKey(orgText, textFieldKey.getText());

        String encrText = action.encrypt(orgText,key);
        setText(encrText, textFieldEncr);
    }
    public void decryptText(){
        String encrText = textFieldEncr.getText();
        String key = action.generateKey(encrText, textFieldKey.getText());

        String decryptedText = action.decrypt(encrText,key);
        setText(decryptedText, textFieldOrg);
    }
    public void setText(String encrText, JTextField field){
        field.setText(encrText);
    }
}
