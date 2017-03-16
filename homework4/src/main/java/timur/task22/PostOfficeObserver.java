package timur.task22;

public interface PostOfficeObserver extends Observer {
    void registerSubscriber(SubscriberObserver subscriber);

    void sendPostToAllSubscribers();
}
