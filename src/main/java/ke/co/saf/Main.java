package ke.co.saf;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Cipher cipher = new Cipher();
        System.out.println("Encode V => " + cipher.encodeChar('V', 2));
        System.out.println("Decode X => " + cipher.decodeChar('X', 2));
    }
}