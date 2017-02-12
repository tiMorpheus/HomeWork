package task6.calculation;

import org.junit.Test;
import task6.ShapeSetUpTest;

import static org.junit.Assert.assertEquals;

public class PerimeterCalculate extends ShapeSetUpTest {


    @Test
    public void ringTest(){
        assertEquals(62.8, ring.calculatePerimeter(), 1);
    }

    @Test
    public void triangleTest(){
        assertEquals(12, triangle.calculatePerimeter(), 1);
    }

    @Test
    public void quadrangleTest(){
        assertEquals(12, quadrangle.calculatePerimeter(), 1);
    }

    @Test
    public void parallelogramTest(){
        assertEquals(12, parallelogramHeight.calculatePerimeter(), 1);
        assertEquals(38, rectangleParallelogram.calculatePerimeter(), 1);
    }

    @Test
    public void trapeziumTest(){
        assertEquals(12, triangle.calculatePerimeter(), 1);
    }

}
