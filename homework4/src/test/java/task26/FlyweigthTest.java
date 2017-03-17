package task26;

import org.junit.Before;
import org.junit.Test;
import timur.task26.Bacterium;
import timur.task26.BacteryMultiply;

import java.util.List;

public class FlyweigthTest {

    BacteryMultiply colony;

    @Before
    public void setUp(){

        colony = new BacteryMultiply();

    }


    @Test
    public void setColony(){

        List<Bacterium> bacteriumList = colony.multiplyBacterium(10);


        for (Bacterium bacterium : bacteriumList){
            System.out.println(bacterium);
        }
    }

}
