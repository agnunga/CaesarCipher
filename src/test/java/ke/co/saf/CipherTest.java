package ke.co.saf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CipherTest {

    @Test
    public void testEncoding() {

        Cipher cipher = new Cipher();
        String input = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        String encodedString = "QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD";

        cipher.setKey(23);
        assertEquals(encodedString, cipher.encodeSentence(input));
        assertEquals(input, cipher.decodeSentence(encodedString));

        /*
        System.out.println("Encode T => " + cipher.encodeChar('T'));
        System.out.println("Decode Q => " + cipher.decodeChar('Q'));

        String encoded = cipher.encodeSentence(inputString);
        String decoded = cipher.decodeSentence(encoded);

        System.out.println("Input String: " + inputString
                + "\nEncrypted String: " + encoded);
        System.out.println("Decrypted String: " + decoded);
        */

    }

}
