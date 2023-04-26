package ke.co.saf;

import java.util.Scanner;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Cipher cipher = new Cipher();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type the text to cipher then press Enter.");
        System.out.println("Enter the patch of the file to cipher(including the filename).");

        String path = scanner.nextLine();

        System.out.println("Enter cipher key(Must be a number between 1 and 25 inclusive).");

        String keyString = scanner.nextLine();
        int key = Integer.parseInt(keyString);

        if (cipher.validKey(key))
            cipher.setKey(key);

        // "/Users/agunga/Documents/test.txt"
        String encodedText = cipher.encodeTextFile(path);

        System.out.println("Input path: " + path
                + "\nEncrypted String: " + encodedText);

    }

}