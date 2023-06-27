package task_3;

import java.util.ArrayList;
import java.util.List;

interface Subscriber {
    void update(String publication);
}

class PublishingHouse {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publish(String publication) {
        System.out.println("Издательство получило новое издание: " + publication);

        for (Subscriber subscriber : subscribers) {
            subscriber.update(publication);
        }
    }
}

class PostOffice implements Subscriber {
    private String name;

    public PostOffice(String name) {
        this.name = name;
    }

    @Override
    public void update(String publication) {
        System.out.println("Почтовое отделение " + name + " отправляет издание: " + publication);
    }
}

public class Main {
    public static void main(String[] args) {
        PublishingHouse publishingHouse = new PublishingHouse();
        PostOffice postOffice1 = new PostOffice("'Почтовое отделение 1'");
        PostOffice postOffice2 = new PostOffice("'Почтовое отделение 2'");
        publishingHouse.subscribe(postOffice1);
        publishingHouse.subscribe(postOffice2);
        publishingHouse.publish("Газета №1");
        publishingHouse.unsubscribe(postOffice2);
        publishingHouse.publish("Журнал №2");
    }
}