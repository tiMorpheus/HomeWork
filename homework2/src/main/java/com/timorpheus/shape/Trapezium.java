package com.timorpheus.shape;

import com.timorpheus.shape.util.Validator;

public class Trapezium extends Quadrangle {

    private double height;

    public Trapezium(double sideTop, double sideBottom, double height) {
        super();
        this.setSideTop(sideTop);
        this.setSideBottom(sideBottom);
        this.setHeight(height);
    }


    public Trapezium(double sideTop, double sideLeft, double sideBottom, double sideRight) {
        super(sideTop, sideLeft, sideBottom, sideRight);
    }

    public Trapezium(double sideTop, double sideLeft, double sideDown, double sideRight, double height) {
        super(sideTop, sideLeft, sideDown, sideRight);
        this.setHeight(height);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        Validator.validate(height);
        this.height = height;
    }

    @Override
    public double calculateArea() {

        this.setArea((this.getSideTop() + this.getSideBottom()) / 2 * height);

        return this.getArea();
    }
}
