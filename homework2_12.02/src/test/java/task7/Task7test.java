package task7;

import com.timorpheus.task7.Area;
import com.timorpheus.task7.City;
import com.timorpheus.task7.Country;
import com.timorpheus.task7.District;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task7test {

    City kiev, lviv, odessa;
    District districtKyiv, districtLviv, districtOdessa;
    Area areaKyiv, areaLviv, areaOdessa;
    Country country;

    @Before
    public void init() {

        kiev = new City("Kyiv", 3_000_000);
        lviv = new City("lviv", 1_500_000);
        odessa = new City("Odessa", 2_000_000);

        districtKyiv = new District("Kyiv district", 150_000);
        districtKyiv.addCity(kiev);

        districtLviv = new District("Lviv district", 50_000);
        districtLviv.addCity(lviv);

        districtOdessa = new District("Odessa district", 120_000);
        districtOdessa.addCity(odessa);

        areaKyiv = new Area("Kyiv area", kiev);
        areaKyiv.addDistrict(districtKyiv);

        areaLviv = new Area("Lviv area", lviv);
        areaLviv.addDistrict(districtLviv);

        areaOdessa = new Area("Odessa area", odessa);
        areaOdessa.addDistrict(districtOdessa);

        country = new Country("Ukraine", kiev);
        country.addAreas(areaKyiv, areaOdessa, areaLviv);

    }

    @Test
    public void printCapitalTest() {
        country.printCapital();
        assertEquals("Kyiv", country.getCapital());
    }

    @Test
    public void printAmountOfAreas() {
        country.printAreas();
        assertEquals(3, country.getAreasAmount());
    }

    @Test
    public void printSquare(){
        country.printSquare();
        assertEquals(320_000,country.calculateSquare(),1);
    }

}
