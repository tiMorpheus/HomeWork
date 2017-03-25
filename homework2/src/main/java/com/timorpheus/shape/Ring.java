package com.timorpheus.shape;

import com.timorpheus.shape.util.Validator;

public class Ring extends Shape {

    private double radius;

    public Ring(double radius) {
        this.setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        Validator.validate(radius);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        this.setArea(Math.PI * this.radius * this.radius);
        return this.getArea();
    }

    @Override
    public double calculatePerimeter() {
        this.setPerimeter(2 * Math.PI * this.radius);
        return this.getPerimeter();
    }
}
