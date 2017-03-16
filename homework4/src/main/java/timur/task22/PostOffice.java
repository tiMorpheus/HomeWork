package timur.task22;

import java.util.ArrayList;
import java.util.List;

public class PostOffice implements PostOfficeObserver {

    private String postOfficeName;

    public PostOffice(String postOfficeName) {
        this.postOfficeName = postOfficeName;
    }

    private List<SubscriberObserver> subscribers = new ArrayList();
    private List<Magazine> magazines = new ArrayList<>();

    public List<SubscriberObserver> getSubscribers() {
        return subscribers;
    }

    @Override
    public void takeNewMagazine(Magazine magazine) {
        magazines.add(magazine);
    }

    @Override
    public void registerSubscriber(SubscriberObserver subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void sendPostToAllSubscribers() {
        for (SubscriberObserver subscriber : subscribers) {
            for (Magazine magazine : magazines) {
                subscriber.takeNewMagazine(magazine);
            }
        }
    }

    @Override
    public String toString() {
        return "PostOffice " + postOfficeName;
    }
}
