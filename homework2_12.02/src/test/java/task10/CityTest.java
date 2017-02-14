package task10;

import com.timorpheus.task10.City;
import com.timorpheus.task10.StreetType;
import org.junit.Before;
import org.junit.Test;

public class CityTest {

    City city;


    @Before
    public void init() {


        city = new City("Kyiv", 100000);
        City.Street street = city.new Street("Mazepy",20,10.3, StreetType.STREET);

        city.addStreet(street);
        city.addStreet(city.new Street("k",10,10.3, StreetType.STREET));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeValueOfPopulationTest(){
        City noName = new City("Noname", -1000);
    }

}