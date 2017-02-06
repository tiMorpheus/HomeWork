package com.timorpheus.task5;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Task5 {

        private BigInteger n;
        private BigInteger d;
        private BigInteger e;

        private int bitlen = 1024;


        /** Create an instance that can both encrypt and decrypt. */
        public Task5(int bits) {
            bitlen = bits;
            SecureRandom r = new SecureRandom();
            BigInteger p = new BigInteger(bitlen / 2, 100, r);
            BigInteger q = new BigInteger(bitlen / 2, 100, r);
            n = p.multiply(q);
            BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q
                    .subtract(BigInteger.ONE));
            e = new BigInteger("3");
            while (m.gcd(e).intValue() > 1) {
                e = e.add(new BigInteger("2"));
            }
            d = e.modInverse(m);
        }

        /** Encrypt the given plaintext message. */
        public String encrypt(String message) {
            return (new BigInteger(message.getBytes())).modPow(e, n).toString();
        }

        /** Decrypt the given ciphertext message. */
        public String decrypt(String message) {
            return new String((new BigInteger(message)).modPow(d, n).toByteArray());
        }


}
