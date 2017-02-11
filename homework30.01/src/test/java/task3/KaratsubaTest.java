package task3;


import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static com.timorpheus.task3.Karatsuba.karatsubaMultiplication;


public class KaratsubaTest {

    @Test(expected = IllegalArgumentException.class)
    public void karaNullPointerExc() {
        BigInteger a = null;
        BigInteger b = null;
        karatsubaMultiplication(a, b);
    }


    @Test(expected = IllegalArgumentException.class)
    public void karaNullPointerExc2() {
        BigInteger a = null;
        BigInteger b = new BigInteger("4214214");
        karatsubaMultiplication(a, b);
    }

    @Test(expected = IllegalArgumentException.class)
    public void karaNullPointerExc3() {
        BigInteger a = new BigInteger("4214214");
        BigInteger b = null;
        karatsubaMultiplication(a, b);
    }

    @Test
    public void kara() throws Exception {
        BigInteger a = new BigInteger("5125");
        BigInteger b = new BigInteger("4214214");
        assertEquals(new BigInteger("21597846750"), karatsubaMultiplication(a, b));
    }

    @Test
    public void karaNegativeValue() throws Exception {
        BigInteger a = new BigInteger("-321321312312");
        BigInteger b = new BigInteger("42142141421412");
        assertEquals(new BigInteger("-13541168185165996856024544"), karatsubaMultiplication(a, b));
    }

    @Test
    public void karaWithNull1() throws Exception {
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("4214214");
        assertEquals(new BigInteger("0"), karatsubaMultiplication(a, b));
    }

    @Test
    public void karaWithNull2() throws Exception {
        BigInteger a = new BigInteger("4214214");
        BigInteger b = new BigInteger("0");
        assertEquals(new BigInteger("0"), karatsubaMultiplication(a, b));
    }
}
