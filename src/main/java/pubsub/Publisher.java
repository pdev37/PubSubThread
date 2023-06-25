package pubsub;



public class Publisher implements Runnable {
    private final Broker broker;

    public Publisher(Broker broker) {
        this.broker = broker;
    }

    public void publish(int message) {
        System.out.println("Published: " + message);
        broker.publish(message);
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {

        }
    }
}

