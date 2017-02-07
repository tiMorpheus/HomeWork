package Task5;

import com.timorpheus.task5.RSA;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Task5test {

    RSA serverRsa;
    RSA clientRsa;
    BigInteger encryptMessage;
    BigInteger message = new BigInteger("Hello java world".getBytes());

    @Before
    public void init() throws Exception {

        int N = 1024;           //amount of bits to key generating

        serverRsa = new RSA();
        clientRsa = new RSA();

        serverRsa.init(N);

        clientRsa.setModulus(serverRsa.getModulus());
        clientRsa.setPublicKey(serverRsa.getPublicKey());

        encryptMessage = clientRsa.encrypt(message);
    }

    @Test
    public void clientEncryptTest() {


        assertNotEquals(encryptMessage, message);
    }

    @Test
    public void decryptStringTest() {

        BigInteger decryptMessage = serverRsa.decrypt(encryptMessage);

        assertEquals(decryptMessage, new BigInteger("Hello java world".getBytes()));


    }


}
