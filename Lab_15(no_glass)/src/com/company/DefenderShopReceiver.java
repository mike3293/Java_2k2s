package com.company;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.*;

public class DefenderShopReceiver implements MessageListener {

    ConnectionFactory factory = new ConnectionFactory();
    JMSConsumer consumerT;
    static int counterID = 0;

    DefenderShopReceiver() {
        try (JMSContext context = factory.createContext("admin", "admin")) {
            context.setClientID(String.valueOf((counterID++)));

            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
            Topic Topic = context.createTopic("DefenderTopic");
            consumerT = context.createDurableConsumer(Topic, "DurableConsumer");
            consumerT.setMessageListener(this);
            System.out.println("Start listening");
            Thread.sleep(2000000);
            context.unsubscribe("DurableConsumer");
        } catch (JMSException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(message.getBody(String.class));
        } catch (JMSException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new DefenderShopReceiver();
    }
}