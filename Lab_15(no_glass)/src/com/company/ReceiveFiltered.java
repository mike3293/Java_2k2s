package com.company;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.*;

public class ReceiveFiltered implements MessageListener {

    ConnectionFactory factory = new ConnectionFactory();
    JMSConsumer consumer;

    ReceiveFiltered() {
        try (JMSContext context = factory.createContext("admin", "admin")) {
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676,mq://127.0.0.1:7676");

            String selector = "magicNum=666";

            Destination Queue = context.createQueue("FilterQueue");

            consumer = context.createConsumer(Queue, selector);

            consumer.setMessageListener(this);
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
            System.out.println("Message filter: " + message.getIntProperty("magicNum"));
        } catch (JMSException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ReceiveFiltered();
    }
}