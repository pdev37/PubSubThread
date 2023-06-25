package pubsub;


public class Subscriber implements Runnable {
    private final Broker broker;
    private final String name;

    public Subscriber(Broker broker, String name) {
        this.broker = broker;
        this.broker.subscribe(this);
        this.name = name;
    }

    public void receive(Integer message) {
        System.out.println(name + " Received: " + message);
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {

        }
    }
}


