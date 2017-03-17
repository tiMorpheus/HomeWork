package timur.task26;

import java.util.HashMap;
import java.util.Map;

public class BacteriumFactory {

    private static Map<Form, Bacterium> bacteriumMap = new HashMap<>();

    public static Bacterium getBacterium(Form bacteriumForm){
        Bacterium bacterium = bacteriumMap.get(bacteriumForm);

        if (bacterium == null){
            bacterium = new Bacterium(bacteriumForm);
            bacteriumMap.put(bacteriumForm, bacterium);
        }

        return bacterium;
    }
}
