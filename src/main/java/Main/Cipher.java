package Main;

public class Cipher {
    public String generateKey(String orgText, String key){
        int l = orgText.length();

        for (int i=0, j=0; j < l ;i++){
            if(i == l){
                i = 0;
            }
            if(key.length() < l){
                key += key.charAt(i);
            }
            j++;
        }
        key = key.toUpperCase();
        return key;
    }
    public String encryption(String orgText, String key){

        String encrText = "";

        orgText = orgText.toUpperCase();

        for(int i = 0, j = 0; i < orgText.length(); i++){
            char c = orgText.charAt(i);
            if (Character.isLetter(c)) {
                int x = (orgText.charAt(i) + key.charAt(i)) % 26;
                x += 'A';
                encrText += (char) (x);
            }
            else{
                encrText += c;
            }
        }
        return encrText;

    }
    public String decryption(String encrText, String key){

        String orgText = "";

        encrText = encrText.toUpperCase();

        for (int i = 0; i < encrText.length(); i++){
            char c = encrText.charAt(i);
            if(Character.isLetter(c)) {
                int y = (encrText.charAt(i) - key.charAt(i) + 26) % 26;
                y += 'A';
                orgText += (char) (y);
            }
            else{
                orgText+=c;
            }
        }
        return orgText;
    }
}
