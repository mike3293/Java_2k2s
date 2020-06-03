package com.company;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.*;

public class ReceiveCommon implements MessageListener {

    ConnectionFactory factory = new ConnectionFactory();
    JMSConsumer queue;
    JMSConsumer topics;

    ReceiveCommon() {
        try (JMSContext context = factory.createContext("admin", "admin")) {
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
            Destination Queue = context.createQueue("Queue");
            queue = context.createConsumer(Queue);
            queue.setMessageListener(this);
            Destination Topic = context.createTopic("Topic");
            topics = context.createConsumer(Topic);
            topics.setMessageListener(this);
            System.out.println("Start listening");
            Thread.sleep(1200000);
        } catch (JMSException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Message body: " + message.getBody(String.class));
            System.out.println("Message destination: " + message.getJMSDestination());
        } catch (JMSException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ReceiveCommon();
    }
}
