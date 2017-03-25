package com.timorpheus.shape;

public class Parallelogram extends Quadrangle {

    private double height;
    private ParallelogramForm parallelogramForm;

    // square
    public Parallelogram(double side) {
        super();
        this.setSideLeft(side);
        this.setSideBottom(side);
        this.parallelogramForm = ParallelogramForm.SQUARE;
    }

    // rectangle
    public Parallelogram(double sideLeft, double sideBottom) {
        super();
        this.setSideLeft(sideLeft);
        this.setSideBottom(sideBottom);
        this.parallelogramForm = ParallelogramForm.RECTANGLE;
    }

    public Parallelogram(double sideLeft, double sideBottom, double height) {
        super();
        this.setSideLeft(sideLeft);
        this.setSideBottom(sideBottom);
        this.setHeight(height);
        this.parallelogramForm = ParallelogramForm.PARALLELOGRAM;
    }

    public Parallelogram(double sideTop, double sideBottom, double sideLeft, double sideRight) {
        super(sideTop, sideBottom, sideLeft, sideRight);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public ParallelogramForm getParallelogramForm() {
        return parallelogramForm;
    }

    public void setParallelogramForm(ParallelogramForm parallelogramForm) {
        this.parallelogramForm = parallelogramForm;
    }

    @Override
    public double calculateArea() {

        if (this.parallelogramForm == ParallelogramForm.RECTANGLE || this.parallelogramForm == ParallelogramForm.SQUARE) {
            this.setArea(this.getSideLeft() * this.getSideBottom());
        } else if (this.parallelogramForm == ParallelogramForm.PARALLELOGRAM) {
            this.setArea(this.getSideBottom() * this.getHeight());
        } else {
            this.setArea(super.calculateArea());
        }

        return this.getArea();
    }

    @Override
    public double calculatePerimeter() {

        if (this.parallelogramForm == ParallelogramForm.RECTANGLE ||
                this.parallelogramForm == ParallelogramForm.SQUARE ||
                this.parallelogramForm == ParallelogramForm.PARALLELOGRAM) {

            this.setPerimeter(2 * (this.getSideLeft() + this.getSideBottom()));
        } else {
            this.setPerimeter(super.calculatePerimeter());
        }

        return this.getPerimeter();
    }
}
