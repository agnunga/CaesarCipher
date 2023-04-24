package ke.co.saf;

public class Cipher {

    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public char encodeChar(char c, int key){
        int index = alphabet.indexOf(c);
        // System.out.println("Index of " + c + " is " + index);
        return alphabet.charAt((index + key)%26);
    }

    public char decodeChar(char c, int key){
        return encodeChar(c, (key*-1+26));
    }

    public String encodeSentence(String sentence, int key){

        for (int i = 0; i<alphabet.length(); i++){
            sentence.replace(alphabet.charAt(i), encodeChar(alphabet.charAt(i), key));
        }
        return sentence;
    }
}
