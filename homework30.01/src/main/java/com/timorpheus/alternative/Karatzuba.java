package com.timorpheus.alternative;


public final class Karatzuba {

    private Karatzuba() {
    }

    public static long karatsuba(long x, long y) {

        int size1 = getSize(x);
        int size2 = getSize(y);

        /** Maximum of lengths of number **/
        int maxLength = Math.max(size1, size2);

        /** for small values directly multiply **/
        if (maxLength < 10)
            return x * y;

        /** max length divided, rounded up **/
        maxLength = (maxLength / 2) + (maxLength % 2);

        /** multiplier **/
        long m = (long) Math.pow(10, maxLength);

        /** compute sub expressions **/
        long b = x / m;
        long a = x - (b * m);
        long d = y / m;
        long c = y - (d * maxLength);
        /** compute sub expressions **/
        long z0 = karatsuba(a, c);
        long z1 = karatsuba(a + b, c + d);
        long z2 = karatsuba(b, d);

        return z0 + ((z1 - z0 - z2) * m) + (z2 * (long) (Math.pow(10, 2d * maxLength)));
    }

    /**
     * Function to calculate length or number of digits in a number
     **/
    private static int getSize(long num) {
        int ctr = 0;
        long tmp = num;
        while (tmp != 0) {
            ctr++;
            tmp /= 10;
        }
        return ctr;
    }

}


