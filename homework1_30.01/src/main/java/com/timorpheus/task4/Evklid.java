package com.timorpheus.task4;

public final class Evklid {

    private Evklid() {
    }

    // greatest common divisor
    public static int gcd(int a, int b) {

        /** gcd(-a, b) == gcd(a,b) , gcd(-a, -b) == gcd(a,b), gcd(a, -b) == gcd(a,b) */
        if (a < 0 || b < 0) {
            a = Math.abs(a);
            b = Math.abs(b);
        }
        /** gcd(20, 20) == 20 */
        if (a == b) {
            return a;
        }

        /** GCD(0,b) == b; GCD(a,0) == a, GCD(0,0) == 0 */
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }


        int shift;

        /** Let shift := lg K, where K is the greatest power of 2
         dividing both a and b. */
        for (shift = 0; ((a | b) & 1) == 0; ++shift) {
            a >>= 1;
            b >>= 1;
        }

        while ((a & 1) == 0)
            a >>= 1;

        /** From here on, a is always odd. */
        do {

            /** remove all factors of 2 in b -- they are not common
             note: b is not zero, so while will terminate */
            while ((b & 1) == 0)
                b >>= 1;


            /** Now a and b are both odd. Swap if necessary so a <= b,
             then set b = b - a (which is even). For bignums, the
             swapping is just pointer movement, and the subtraction
             can be done in-place. */
            if (a > b) {
                int tmp = b;  // Swap a and b.
                b = a;
                a = tmp;
            }

            b = b - a;      // Here b >= a.

        } while (b != 0);

        /** restore common factors of 2 */
        return a << shift;
    }
}
