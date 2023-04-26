package ke.co.saf;

import java.util.Scanner;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Cipher cipher = new Cipher();
        Scanner scanner = new Scanner(System.in);

        boolean promptUser = true;
        int key = 0;
        String path;// "/Users/agunga/Documents/test.txt"

        do {
            System.out.println("Select action(e-encode, d-decode)");

            String action = scanner.nextLine();

            if (action.toLowerCase().startsWith("e")) {

                path = fetchPath(scanner);
                key = fetchKey(scanner);
                while (!cipher.validKey(key)) {
                    System.out.println("Invalid Key!\nTry again! Key must be a number between 1 and 25 inclusive.");
                    key = fetchKey(scanner);
                }
                cipher.setKey(key);

                String encodedText = cipher.encodeTextFile(path);
                if (cipher.writeTextFile(path + "_encoded", encodedText))
                    System.out.println("Encoded file: " + path + "_encoded");
                else
                    System.out.println("Encoding failed.");
            } else if (action.toLowerCase().startsWith("d")) {
                path = fetchPath(scanner);
                key = fetchKey(scanner);
                while (!cipher.validKey(key)) {
                    System.out.println("Invalid Key!\nTry again! Key must be a number between 1 and 25 inclusive.");
                    key = fetchKey(scanner);
                }
                cipher.setKey(key);
                String decodedText = cipher.decodeTextFile(path);
                if (cipher.writeTextFile(path + "_decoded", decodedText))
                    System.out.println("Decoded file: " + path + "_decoded");
                else
                    System.out.println("Decoding failed!");

            } else {
                System.out.println("Invalid action. Do you want yo try again? (Y-yes)");
                if (scanner.nextLine().toLowerCase().startsWith("y"))
                    continue;
                else break;
            }

            System.out.println("Do you want to perform another action? (Y-yes)");
            promptUser = scanner.nextLine().toLowerCase().startsWith("y");

        } while (promptUser);
    }

    private static String fetchPath(Scanner scanner) {
        System.out.println("Enter the path of the file to cipher(including the filename).");
        return scanner.nextLine();
    }

    private static int fetchKey(Scanner scanner) {

        System.out.println("Enter cipher key(Must be a number between 1 and 25 inclusive).");
        String keyString = scanner.nextLine();

        try {
            return Integer.parseInt(keyString);
        } catch (final NumberFormatException e) {
            System.out.println("Invalid number!" + e.getMessage());
            return 0;
        }
    }

}