package task22;

import org.junit.Before;
import org.junit.Test;
import timur.task22.PostOffice;
import timur.task22.Publisher;
import timur.task22.Subsriber;

import static org.junit.Assert.assertEquals;

public class ObserverTest {

    Publisher publisher;
    Subsriber subsriber1;
    Subsriber subsriber2;
    PostOffice postOffice;


    @Before
    public void setUp(){

        publisher = new Publisher("PUBLISHER 1");

        postOffice = new PostOffice("POST OFFICE 1");

        publisher.registerObserver(postOffice);

        subsriber1 = new Subsriber();
        subsriber2 = new Subsriber();

        postOffice.registerSubscriber(subsriber1);
        postOffice.registerSubscriber(subsriber2);
    }

    @Test
    public void registerPostOffices(){
        System.out.println("current postOffices :" + publisher.getPostOffices());

        publisher.registerObserver(new PostOffice("POST OFFICE 2"));

        System.out.println("current postOffices :" + publisher.getPostOffices());
    }
    @Test
    public void removePostOffices(){

        System.out.println("current postOffices :" + publisher.getPostOffices());

        publisher.removeObserver(postOffice);

        System.out.println("current postOffices :" + publisher.getPostOffices());
    }

    @Test
    public void publishMagazine(){
        publisher.publish("Times");
        postOffice.sendPostToAllSubscribers();
        System.out.println(subsriber1.getMagazines());
        System.out.println(subsriber2.getMagazines());
    }


}
