package com.timorpheus.task1;

public class BitOperation {

    public int countByte() {
        byte number = 1;
        int i = 1;
        while (number > 0) {
            number <<= 1;
            i++;
        }
        return i;
    }

    public int countShort() {
        short number = 1;
        int i = 1;
        while (number > 0) {
            number <<= 1;
            i++;
        }
        return i;
    }

    public int countInt() {
        int number = 1;
        int i = 1;
        while (number > 0) {
            number <<= 1;
            i++;
        }
        return i;
    }

    public int countLong() {
        long number = 1;
        int i = 1;
        while (number > 0) {
            number <<= 1;
            i++;
        }
        return i;
    }


}
