package ke.co.saf;

public class Cipher {

    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public char encodeChar(char c, int key){
        int index = alphabet.indexOf(c);
        // System.out.println("Index of " + c + " is " + index);
        return alphabet.charAt((index + key)%26);
    }

}
