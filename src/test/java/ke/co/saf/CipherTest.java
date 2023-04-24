package ke.co.saf;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CipherTest {

    @Test
    public void testEncoding(){

        Cipher cipher = new Cipher();
        String input = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        String encodedString = "QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD";

        cipher.setKey(23);
        assertEquals(encodedString, cipher.encodeSentence(input));
        assertEquals(input, cipher.decodeSentence(encodedString));


    }

}
