package pubsub;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Broker {
    private final Queue<Integer> messages = new ConcurrentLinkedQueue<>();
    private final Set<Subscriber> subscribers = new HashSet<>();


    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void publish(Integer message) {
        messages.add(message);
        dispatch();
    }

    private void dispatch() {
        if(!messages.isEmpty()) {
            Integer message = messages.poll();
            for (Subscriber subscriber : subscribers) {
                subscriber.receive(message);
            }
        }
    }
}
