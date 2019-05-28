package com.accenture.flowershop.be.business.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.jms.*;

@Service
public class JmsService {
    @Autowired
    private ApplicationContext context;

    @Autowired
    private ConnectionFactory connectionFactory;


    private Queue outQueue;
    private Queue inQueue;
    private Connection connection;
    private Session session;
    private MessageProducer messageProducer;
    private MessageConsumer messageConsumer;


    @PostConstruct
    public void initialize()
    {
        try {
            outQueue = (Queue)context.getBean("outQueue");
            inQueue = (Queue) context.getBean("inQueue");
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            messageProducer = session.createProducer(outQueue);
            messageConsumer = session.createConsumer(inQueue);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    //отправляем
    public void sendMessageJMS(String msq){
        try {
            Message message = session.createTextMessage(msq);
            messageProducer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
   /* public String receiveMessage(){
        String body=null;
        try {
            try {
                //Session session =connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
              // messageConsumer = session.createConsumer(inQueue);
               TextMessage textMessage = (TextMessage)messageConsumer.receive();
               body = textMessage.getText();
            } finally {
                connection.close();
            }
        } catch (JMSException ex) {
            // handle exception (details omitted)
        }
        return body;
    }*/
}
