package com.timorpheus.shape;

public abstract class Shape {

    private double perimeter;
    private double area;


    public double getPerimeter() {

        return this.perimeter;
    }

    public double getArea() {
        return area;
    }


    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    public double addAreas(Shape anotherShape) {

        return this.getArea() + anotherShape.getArea();
    }


}
