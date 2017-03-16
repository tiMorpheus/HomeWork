package timur.task22;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private String publisherName;
    private List<PostOfficeObserver> postOffices = new ArrayList<>();
    private List<Magazine> magazines = new ArrayList<>();


    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }

    public List<PostOfficeObserver> getPostOffices() {
        return postOffices;
    }

    public void publish(String label){
        Magazine magazine = new Magazine(label);
        magazines.add(magazine);
        this.sentToAllPostOffices(magazine);
    }

    private void sentToAllPostOffices(Magazine magazine) {

        for (PostOfficeObserver postOfficeObserver : postOffices){
            postOfficeObserver.takeNewMagazine(magazine);
        }

    }

    public void registerObserver(PostOfficeObserver observer) {
        postOffices.add(observer);
    }

    public void removeObserver(PostOfficeObserver observer) {
        postOffices.remove(observer);
    }


    @Override
    public String toString() {
        return "Publisher " + publisherName;
    }
}
