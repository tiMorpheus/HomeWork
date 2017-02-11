package com.timorpheus.task3;


import java.math.BigInteger;

public final class Karatsuba {

    private Karatsuba() {
    }

    public static BigInteger karatsubaMultiplication(BigInteger i, BigInteger j) {

        if (i == null || j == null) throw new IllegalArgumentException("NULL IS NOT AVAILABLE");


        int n = Math.max(i.bitLength(), j.bitLength());

        if (n <= 5) {
            return i.multiply(j);
        } else {
            n = n / 2 + n % 2;

            BigInteger b = i.shiftRight(n);
            BigInteger a = i.subtract(b.shiftLeft(n));
            BigInteger d = j.shiftRight(n);
            BigInteger c = j.subtract(d.shiftLeft(n));

            BigInteger ac = karatsubaMultiplication(a, c);
            BigInteger bd = karatsubaMultiplication(b, d);
            BigInteger abcd = karatsubaMultiplication(a.add(b), c.add(d));

            return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(n)).add(bd.shiftLeft(2 * n));
        }
    }


}
