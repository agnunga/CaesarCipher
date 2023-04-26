package ke.co.saf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cipher {

    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int key;

    public char encodeChar(char c){

        int index = ALPHABET.indexOf(c);
        int newIndex = index + getKey();

        if (newIndex > 25 )
            newIndex -= 26;

        return ALPHABET.charAt(newIndex);
    }

    public char decodeChar(char c){
        int index = ALPHABET.indexOf(c);
        int newIndex = index - getKey();

        if(newIndex < 0)
            newIndex += 26;

        return ALPHABET.charAt(newIndex);
    }

    public String encodeSentence(String sentence){

        StringBuilder builder = new StringBuilder(sentence);
        for (int i = 0; i<sentence.length(); i++){
            if(ALPHABET.indexOf(sentence.charAt(i)) != -1)
                builder.setCharAt(i, encodeChar(sentence.charAt(i)));
        }
        return builder.toString();
    }

    public String encodeTextFile(String path) {
        return encodeSentence(readTextFile(path));
    }

    public boolean validKey(int key){
        if(key > 25){
            return false;
        }else return key >= 0;
    }

    public String readTextFile(String path) {
        File textFile = new File(path);
        String text = "";

        try {
            Scanner scanner = new Scanner(textFile);
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine()).append("\n");
            }
            text = sb.toString();
        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return text;
    }

    public String decodeSentence(String encodedString) {
        StringBuilder builder = new StringBuilder(encodedString);
        for (int i = 0; i<encodedString.length(); i++){
            if(ALPHABET.indexOf(encodedString.charAt(i)) != -1) {
                builder.setCharAt(i, decodeChar(encodedString.charAt(i)));
            }
        }
        return builder.toString();
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        if (key < 0)
            this.key = key+26;
        else
            this.key = key;
    }
}
