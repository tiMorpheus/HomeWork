package timur.task22;

import java.util.ArrayList;
import java.util.List;

public class Subsriber implements SubscriberObserver{

    private List<Magazine> magazines = new ArrayList<>();

    @Override
    public void takeNewMagazine(Magazine magazine) {
        magazines.add(magazine);
    }

    @Override
    public List<Magazine> getMagazines() {
        return magazines;
    }
}
