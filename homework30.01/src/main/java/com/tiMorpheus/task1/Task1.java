package com.tiMorpheus.task1;

public class Task1 {

    // -- BYTE
    public static int countByte() {

        return amountOfBites((byte) 1);
    }

    /**
     * recursive method of counting bits in type Byte
     *
     * @param value - 1
     * @return - number of bits in type Byte
     */
    private static int amountOfBites(byte value) {
        value = (byte) (value << 1);

        if (value < 0) {
            return 1;
        } else
            return amountOfBites(value) + 1;
    }


    // -- SHORT
    public int countShort() {
        return amountOfBites((short) 1);
    }

    /**
     * recursive method of counting bits in type Short
     *
     * @param value - 1
     * @return - number of bits in type Short
     */
    private int amountOfBites(short value) {
        value = (short) (value << 1);

        if (value < 0) {
            return 2;
        } else
            return amountOfBites(value) + 1;
    }

    // -- INT
    public int countInt() {
        return amountOfBites(1);
    }

    /**
     * recursive method of counting bits in type Int
     *
     * @param value - 1
     * @return - number of bits in type Int
     */
    private int amountOfBites(int value) {
        value = value << 1;

        if (value < 0) {
            return 2;
        } else
            return amountOfBites(value) + 1;
    }


    // -- LONG
    public int countLong() {
        return amountOfBites((long) 1);
    }

    /**
     * recursive method of counting bits in type Long
     *
     * @param value - 1
     * @return - number of bits in type Long
     */
    private int amountOfBites(long value) {
        value = value << 1;

        if (value < 0) {
            return 2;
        } else
            return amountOfBites(value) + 1;
    }

}
