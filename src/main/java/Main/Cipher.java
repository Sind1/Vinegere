package Main;

public class Cipher {
    public String generateKey(String orgText, String key) {
        int l = orgText.length();

        for (int i = 0, j = 0; j < l; i++) {
            if (i == l) {
                i = 0;
            }
            if (key.length() < l) {
                key += key.charAt(i);
            }
            j++;
        }
        key = key.toLowerCase();
        return key;
    }

    public String encrypt(String orgText, String key) {
        StringBuilder encryptedText = new StringBuilder();
        int keyIndex = 0;
        for (char c : orgText.toCharArray()) {
            int keyShift = key.charAt(keyIndex) - 'a';
            int textChar = c;

            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    textChar = (c + keyShift - 'A') % 26 + 'A';
                } else {
                    textChar = (c + keyShift - 'a') % 26 + 'a';
                }
            } else if (Character.isDigit(c)) {
                textChar = (c + keyShift - '0') % 10 + '0';
            } else if (Character.getType(c) == Character.OTHER_PUNCTUATION ||
                    Character.getType(c) == Character.MATH_SYMBOL) {
                textChar = (c + keyShift - 33) % 15 + 33;
            }

            encryptedText.append((char) textChar);

            keyIndex = (keyIndex + 1) % key.length();
        }

        return encryptedText.toString();
    }

    public String decrypt(String encrText, String key) {
        StringBuilder decryptedText = new StringBuilder();

        int keyIndex = 0;
        for (char c : encrText.toCharArray()) {
            int shift = key.charAt(keyIndex) - 'a';
            int textChar = c;

            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    textChar = (c - shift - 'A') % 26;
                    if (textChar < 0) {
                        textChar += 26;
                    }
                    textChar += 'A';
                } else {
                    textChar = (c - shift - 'a') % 26;
                    if (textChar < 0) {
                        textChar += 26;
                    }
                    textChar += 'a';
                }
            } else if (Character.isDigit(c)) {
                textChar = (c - shift - '0') % 10;
                if (textChar < 0) {
                    textChar += 10;
                }
                textChar += '0';
            } else if (Character.getType(c) == Character.OTHER_PUNCTUATION || Character.getType(c) == Character.MATH_SYMBOL) {
                textChar = (c - shift - 33) % 15;
                if (textChar < 0) {
                    textChar += 15;
                }
                textChar += 33;
            }

            decryptedText.append((char) textChar);

            keyIndex = (keyIndex + 1) % key.length();
        }

        return decryptedText.toString();
    }
}