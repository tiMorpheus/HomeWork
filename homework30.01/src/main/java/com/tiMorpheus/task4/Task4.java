package com.timorpheus.task4;

public class Task4 {

    public int nod(int c, int d) {
        int a = c;
        int b = d;

        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        return a + b;
    }
}
