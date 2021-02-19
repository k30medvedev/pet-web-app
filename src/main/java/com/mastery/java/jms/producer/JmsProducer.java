package com.mastery.java.jms.producer;


import com.mastery.java.jms.consumer.JmsConsumer;
import com.mastery.java.model.EmployeeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer {
    private static final Logger logger = LoggerFactory.getLogger(JmsConsumer.class.getName());

    private final JmsTemplate jmsTemplate;

    @Value("${activemq.queue}")
    String queue;

    public JmsProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(EmployeeEntity employeeEntity) {
            jmsTemplate.convertAndSend(queue, employeeEntity);
            logger.info("Employee was sent");

    }
}