package ke.co.saf;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Cipher cipher = new Cipher();
//        System.out.println("Encode T => " + cipher.encodeChar('T', 23));
//        System.out.println("Decode Q => " + cipher.decodeChar('Q', 23));

        String inputString = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        cipher.setKey(23);
        String encoded = cipher.encodeSentence(inputString);
        String decoded = cipher.decodeSentence(encoded);

        System.out.println("Input String: " + inputString
                + "\nEncrypted String: " + encoded);
        System.out.println("Decrypted String: " + decoded);


    }

}