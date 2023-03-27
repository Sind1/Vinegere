package Main;

import Frame.Window;

public class Main {
    public static void main(String[] args) {
        new Window();
        
        Cipher m = new Cipher();
        String text = "Sindija !!";
        String f = m.generateKey(text, "key");
        String encr = m.encrypt(text, f);
        String org = m.decrypt(encr, f);

        System.out.println("Original: " +text);
        System.out.println("Key: " + f);
        System.out.println("Encrypted: " + encr);
        System.out.println("Decripted: " + org);
    }
}