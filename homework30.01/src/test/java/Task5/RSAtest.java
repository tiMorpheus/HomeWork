package Task5;

import com.timorpheus.task5.RSA;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class RSAtest {

    private RSA rsaServer;
    private RSA rsaClient;
    private BigInteger message;
    private BigInteger encrypted;
    private BigInteger decrypted;

    @Before
    public void setUp() throws Exception{
        rsaServer = new RSA();
        rsaClient = new RSA();
        rsaServer.init(1024);
        rsaClient.setModulus(rsaServer.getModulus());
        rsaClient.setPublicKey(rsaServer.getPublicKey());

        message = new BigInteger("TEST MESSAGE".getBytes());

        encrypted = rsaServer.encrypt(message);
    }

    @Test(expected = NullPointerException.class)
    public void rsaEncryptionNullMessageTest() throws Exception {
        message = null;
        rsaServer.encrypt(message);
    }


    @Test(expected = NullPointerException.class)
    public void rsaDecryptionNullMessageTest() throws Exception{
        message = null;
        rsaServer.decrypt(message);
    }

    @Test
    public void encryptTest() throws Exception {
        encrypted = rsaClient.encrypt(message);
        assertNotEquals(message, encrypted);
    }


    @Test
    public void decrypt() throws Exception {

        decrypted = rsaServer.decrypt(encrypted);
        assertEquals(message, decrypted);
    }

}
