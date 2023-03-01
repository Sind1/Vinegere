package Main;

import Frame.Window;

public class Main {
    public static void main(String[] args) {
        new Window();
        Cipher m = new Cipher();
        String f = m.generateKey("SINDIJA TAMULYTE", "HEYO");
        String encr = m.encryption("SINDIJA TAMULYTE", f);
        String f2 = m.generateKey(encr, "HEYO");
        String org = m.decryption(encr, f2);

        System.out.println("Encrypted: " + encr);
        System.out.println("decrip: " + org);
    }
}