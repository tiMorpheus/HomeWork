package task6.exceptions;

import com.timorpheus.shape.*;
import org.junit.Test;
import task6.ShapeSetUpTest;

public class IllegalArgumentsTesting extends ShapeSetUpTest {


    @Test(expected = IllegalArgumentException.class)
    public void nullValueRingIAETest() {
        ring = new Ring(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeValueRingIAETest() {
        ring = new Ring(-5);
    }


    @Test(expected = IllegalArgumentException.class)
    public void nullValueTriangleIAETest() {
        // triangle = new Triangle(0);
        triangle.setSide2(0);
        //triangle.setSide3(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeValueTriangleIAETest() {
        triangle = new Triangle(-5);
    }


    @Test(expected = IllegalArgumentException.class)
    public void nullValueQuadrangleIAETest() {
        quadrangle = new Quadrangle(0, 1, 1 , 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeValueQuadrangleIAETest() {
        quadrangle = new Quadrangle(-5, -5, -5 ,- 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullValueParallelogramIAETest() {
        rectangleParallelogram = new Parallelogram(0, 1, 1 , 1);
        parallelogramHeight = new Parallelogram(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeValueParallelogramIAETest() {
        parallelogramHeight = new Parallelogram(-5, -5, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullValueTrapeziumIAETest() {
        trapezium = new Trapezium(0,0,0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeValueTrapeziumIAETest() {
        trapezium = new Trapezium(-5, -5, -9);
    }
}
