package com.timorpheus.shape;

import com.timorpheus.shape.util.Validator;

public class Triangle extends Shape {

    private double side1;
    private double side2;
    private double side3;


    /**
     * Constructors
     */
    // side1 = side2 = side3
    public Triangle(double side) {
        this.setSide1(side);
        this.setSide2(side);
        this.setSide3(side);
    }

    // side1 = side2
    public Triangle(double side1, double side2) {
        this.setSide1(side1);
        this.setSide2(side1);
        this.setSide3(side2);
    }

    public Triangle(double side1, double side2, double side3) {

        this.setSide1(side1);
        this.setSide2(side2);
        this.setSide3(side3);
    }

    /**
     * Getters and Setters
     */
    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        Validator.validate(side1);
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        Validator.validate(side2);
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        Validator.validate(side3);
        this.side3 = side3;
    }

    /**
     * Methods
     */
    @Override
    public double calculateArea() {

        this.calculatePerimeter();

        this.setArea(Math.sqrt(this.getPerimeter() * (this.getPerimeter() - side1) * (this.getPerimeter() - this.side2) *
                (this.getPerimeter() - this.side3)));

        return this.getArea();
    }

    @Override
    public double calculatePerimeter() {
        this.setPerimeter(this.side1 + this.side2 + this.side3);

        return this.getPerimeter();
    }
}
