package task6.calculation;

import org.junit.Test;
import task6.ShapeSetUpTest;

import static org.junit.Assert.assertEquals;

public class AreaCalculate extends ShapeSetUpTest{


    @Test
    public void ringTest(){
        assertEquals(314.15, ring.calculateArea(), 1);
    }

    @Test
    public void triangleTest(){
        assertEquals(77.76, triangle.calculateArea(), 1);
    }

    @Test
    public void quadrangleTest(){
        assertEquals(8, quadrangle.calculateArea(), 1);
    }

    @Test
    public void parallelogramTest(){
        assertEquals(9, parallelogramHeight.calculateArea(), 1);
        assertEquals(90, rectangleParallelogram.calculateArea(), 1);
    }

    @Test
    public void trapeziumTest(){
        assertEquals(77.76, triangle.calculateArea(), 1);
    }

}
