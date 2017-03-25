package task7;

import org.junit.Test;

public class ExceptionTask7Test extends Task7test {


    @Test(expected = IllegalArgumentException.class)
    public void exceptionTest(){

        country.addAreas(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exception2Test(){

        areaKyiv.addDistrict(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exception3Test(){
        districtKyiv.addCity(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exception4Test(){
        kiev.setPopulation(-1);
    }

}
