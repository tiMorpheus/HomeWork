package com.timorpheus.shape;

import com.timorpheus.shape.util.Validator;

public class Quadrangle extends Shape{

    private double sideTop;
    private double sideBottom;
    private double sideLeft;
    private double sideRight;

    protected Quadrangle() {
    }

    public Quadrangle(double sideTop, double sideBottom, double sideLeft, double sideRight) {
        this.setSideTop(sideTop);
        this.setSideBottom(sideBottom);
        this.setSideLeft(sideLeft);
        this.setSideRight(sideRight);
    }

    public double getSideTop() {
        return sideTop;
    }

    public void setSideTop(double sideTop) {
        Validator.validate(sideTop);
        this.sideTop = sideTop;
    }

    public double getSideBottom() {
        return sideBottom;
    }

    public void setSideBottom(double sideBottom) {
        Validator.validate(sideBottom);
        this.sideBottom = sideBottom;
    }

    public double getSideLeft() {
        return sideLeft;
    }

    public void setSideLeft(double sideLeft) {
        Validator.validate(sideLeft);
        this.sideLeft = sideLeft;
    }

    public double getSideRight() {
        return sideRight;
    }

    public void setSideRight(double sideRight) {
        Validator.validate(sideRight);
        this.sideRight = sideRight;
    }

    @Override
    public double calculateArea() {
        this.calculatePerimeter();
        this.setArea(Math.sqrt((this.getPerimeter() / 2 - this.sideTop) * (this.getPerimeter() / 2 - this.sideLeft) *
                (this.getPerimeter() / 2 - this.sideBottom) * (this.getPerimeter() / 2 - this.sideRight)));
        return this.getArea();
    }

    @Override
    public double calculatePerimeter() {
        this.setPerimeter(this.sideTop + this.sideLeft + this.sideRight + this.sideBottom);
        return this.getPerimeter();
    }
}
