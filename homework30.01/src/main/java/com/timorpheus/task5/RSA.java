package com.timorpheus.task5;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.IllegalFormatException;

public class RSA {
    private final static BigInteger one = new BigInteger("1");
    private final static SecureRandom random = new SecureRandom();

    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger modulus;

    public void init(int bitNumber) {
        BigInteger p = BigInteger.probablePrime(bitNumber / 2, random);
        BigInteger q = BigInteger.probablePrime(bitNumber / 2, random);
        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));

        modulus = p.multiply(q);

        privateKey = publicKey.modInverse(phi);
    }

    public void setPublicKey(BigInteger publicKey) {
        this.publicKey = publicKey;
    }

    public void setModulus(BigInteger modulus) {
        this.modulus = modulus;
    }

    public BigInteger getPublicKey() {
        return publicKey;
    }

    public BigInteger getModulus() {
        return modulus;
    }

    // generate an N-bit (roughly) public and private key
    public RSA() {
        publicKey = new BigInteger("65537");     // common value in practice = 2^16 + 1
    }

    public BigInteger encrypt(BigInteger message) throws NullPointerException {
        if (message instanceof BigInteger) {
            return message.modPow(publicKey, modulus);
        } else {
            throw new NullPointerException("Null");
        }
    }

    public BigInteger decrypt(BigInteger encrypted) throws NullPointerException {
        if (encrypted instanceof BigInteger){
            return encrypted.modPow(privateKey, modulus);
        } else {
            throw new NullPointerException("Null");
        }

    }

}