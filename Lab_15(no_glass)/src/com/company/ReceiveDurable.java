package com.company;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.*;

public class ReceiveDurable implements MessageListener {

    ConnectionFactory factory = new ConnectionFactory();
    JMSConsumer subscriber;
    static int counterID = 0;

    ReceiveDurable() {
        try (JMSContext context = factory.createContext("admin", "admin")) {
            context.setClientID(String.valueOf((counterID++)));

            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
            Topic Topic = context.createTopic("Topic");
            subscriber = context.createDurableConsumer(Topic, "DurableConsumer");
            subscriber.setMessageListener(this);
            System.out.println("Start listening");
            Thread.sleep(1200000);
            context.unsubscribe("DurableConsumer");
        } catch (JMSException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Message body: " + message.getBody(Point.class));
            message.acknowledge();
        } catch (JMSException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ReceiveDurable();
    }
}