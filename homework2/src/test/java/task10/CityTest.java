package task10;

import com.timorpheus.task10.City;
import com.timorpheus.task10.StreetType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CityTest {

    City city;
    City.Street street;

    @Before
    public void init() {


        city = new City("Kyiv", 100000);
        street = city.new Street("Mazepy", 20, 10.3, StreetType.STREET);

        city.addStreet(street);
        city.addStreet(city.new Street("k", 10, 10.3, StreetType.STREET));
    }


    @Test
    public void clearStreet() {
        assertEquals(10, street.clearStreet(),1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeValueOfPopulationTest() {
        City noName = new City("Noname", -1000);
    }


    @Test(expected = IllegalArgumentException.class)
    public void negativeValueOfLengthOfStreetTest() {

        City.Street street = city.new Street("Mazepy", 20, -1, StreetType.STREET);

    }
}