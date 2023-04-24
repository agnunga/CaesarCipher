package ke.co.saf;

public class Cipher {

    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public char encodeChar(char c, int key){
        int index = alphabet.indexOf(c);
        System.out.println("Index of " + c + " is " + index);
        return alphabet.charAt((index + key + 26)%26);
    }

    public char decodeChar(char c, int key){
        return encodeChar(c, (key*-1+26));
    }

    public String encodeSentence(String sentence, int key){

        StringBuilder builder = new StringBuilder(sentence);
        for (int i = 0; i<sentence.length(); i++){
            if(alphabet.indexOf(sentence.charAt(i)) != -1)
                builder.setCharAt(i, encodeChar(sentence.charAt(i), key));
        }
        return builder.toString();
    }

    public String decodeSentence(String encodedString, int key) {
        return encodeSentence( encodedString, key*-1+26);
    }
}
