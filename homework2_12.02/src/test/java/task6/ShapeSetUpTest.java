package task6;

import com.timorpheus.shape.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShapeSetUpTest {

    public Ring ring;
    public Triangle triangle;
    public Quadrangle quadrangle;
    public Parallelogram square;
    public Parallelogram rectangleParallelogram;
    public Parallelogram parallelogramHeight;
    public Trapezium trapezium;

    @Before
    public void setUp() {

            ring = new Ring(10);
            triangle = new Triangle(3, 4, 5);
            quadrangle = new Quadrangle(4, 2, 4, 2);
            square = new Parallelogram(5);
            rectangleParallelogram = new Parallelogram(10, 9);
            parallelogramHeight = new Parallelogram(3, 3, 3);
            trapezium = new Trapezium(20, 23, 15, 20);
    }


    @Test
    public void polymorphismTest(){
        List<Shape> shapes = new ArrayList<Shape>(){{
            add(ring);
            add(triangle);
            add(quadrangle);
            add(square);
            add(rectangleParallelogram);
            add(parallelogramHeight);
            add(trapezium);
        }};

        for (Shape shape : shapes){
            System.out.println(shape);
        }

    }
}
