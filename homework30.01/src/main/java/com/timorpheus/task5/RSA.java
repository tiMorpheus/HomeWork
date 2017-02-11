package com.timorpheus.task5;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {
    private final static BigInteger one = new BigInteger("1");
    private final static SecureRandom random = new SecureRandom();

    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger modulus;
    private final static int bitNumber = 1024;

    // generate an N-bit (roughly) public and private key
    public RSA() {
        publicKey = new BigInteger("65537");
        init();
    }

    private void init() {
        BigInteger p = BigInteger.probablePrime(bitNumber / 2, random);
        BigInteger q = BigInteger.probablePrime(bitNumber / 2, random);
        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));

        modulus = p.multiply(q);

        privateKey = publicKey.modInverse(phi);
    }

    public BigInteger getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(BigInteger privateKey) {
        this.privateKey = privateKey;
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

    public BigInteger encrypt(BigInteger message) throws NullPointerException {

        if (message == null) {
            throw new IllegalArgumentException("No message to encrypt!!!");
        } else {
            return message.modPow(publicKey, modulus);
        }
    }

    public BigInteger decrypt(BigInteger encrypted) throws NullPointerException {

        if (encrypted == null) {
            throw new IllegalArgumentException("No message to decrypt!!!");
        } else {
            return encrypted.modPow(privateKey, modulus);
        }

    }

}