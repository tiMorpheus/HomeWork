package Task5;

import com.tiMorpheus.task5.Task5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Task5test {

    Task5 rsa = new Task5(1024);
    String text = "Some text to encrypt or decrypt";



    @Test
    public void encryptStringTest() {

        String cipherText = rsa.encrypt(text);

        System.out.println(text);
        System.out.println(cipherText);
        assertNotEquals(cipherText, text);

    }



    @Test
    public void decryptStringTest() {

        String cipherString = rsa.encrypt(text);
        String plaintext = rsa.decrypt(cipherString);
        System.out.println(cipherString);
        System.out.println(plaintext);
        assertEquals(plaintext, text);
    }


}
