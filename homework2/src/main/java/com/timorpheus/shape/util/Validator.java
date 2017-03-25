package com.timorpheus.shape.util;

public final class Validator {

    private Validator() {
    }

    public static void validate(double value1) {
        if (value1 <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
