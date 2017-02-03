package com.tiMorpheus.task2;

public class Task2 {

    public int changeBit(int pos, int valueOfBit, int number) {

        if (pos > 32 || pos <= 0) {
            throw new IllegalArgumentException("bit position not available");
        } else if (valueOfBit < 0 || valueOfBit > 1) {
            throw new IllegalArgumentException("value of bit to change not available");
        }

        if (valueOfBit == 0) {
            return number & ~(1 << (pos - 1));
        } else {
            return number | (1 << (pos - 1));
        }
    }
}
