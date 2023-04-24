package ke.co.saf;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CipherTest {

    @Test
    public void testEncoding(){

        Cipher cipher = new Cipher();
        assertEquals('B', cipher.encodeChar('A', 1));

    }

}
