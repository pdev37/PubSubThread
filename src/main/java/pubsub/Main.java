package pubsub;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Broker broker = new Broker();
        Publisher publisher = new Publisher(broker);
        Subscriber subscriber1 = new Subscriber(broker, "sub1");
        Subscriber subscriber2 = new Subscriber(broker, "sub2");

        Thread pubThread = new Thread(publisher);
        Thread sub1Thread = new Thread(subscriber1);
        Thread sub2Thread = new Thread(subscriber2);


        broker.subscribe(subscriber1);

        pubThread.start();
        sub1Thread.start();
        sub2Thread.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers to be published (0 to end): ");

        while (true) {
            int number = scanner.nextInt();

            if (number == 0) {
                break;
            }
            for(int i = 1; i<=number; i ++) {
                publisher.publish(i);
            }

        }

        pubThread.interrupt();
        sub1Thread.interrupt();
        sub2Thread.interrupt();
        scanner.close();
    }
}


