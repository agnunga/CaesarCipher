package ke.co.saf;

import java.util.Scanner;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Cipher cipher = new Cipher();
        Scanner scanner = new Scanner(System.in);

        //System.out.println("Type the text to cipher then press Enter.");
        System.out.println("Enter the path of the file to cipher(including the filename).");
        String path = scanner.nextLine();

        System.out.println("Enter cipher key(Must be a number between 1 and 25 inclusive).");
        String keyString = scanner.nextLine();
        int key = Integer.parseInt(keyString);

        while (!cipher.validKey(key)) {
            System.out.println("Invalid Key!\nTry again! Key must be a number between 1 and 25 inclusive.");
            keyString = scanner.nextLine();
            key = Integer.parseInt(keyString);
        }cipher.setKey(key);

        // "/Users/agunga/Documents/test.txt"
        String encodedText = cipher.encodeTextFile(path);
        if(cipher.writeTextFile(path+"_encoded", encodedText))
            System.out.println("Encoded file: " + path+"_encoded");
        else
            System.out.println("Encoding failed.");

        String decodedText = cipher.decodeTextFile(path+"_encoded");
        if(cipher.writeTextFile(path+"_decoded", decodedText))
            System.out.println("Decoded file: " + path+"_decoded");
        else
            System.out.println("Decoding failed.");

    }

}