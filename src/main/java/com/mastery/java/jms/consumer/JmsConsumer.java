package com.mastery.java.jms.consumer;

import com.mastery.java.model.EmployeeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {
	private static final Logger logger = LoggerFactory.getLogger(JmsConsumer.class.getName());

	@JmsListener(destination = "${activemq.queue}", containerFactory="jsaFactory")
	public void receive(EmployeeEntity employeeEntity ){
		System.out.println("Recieved Message: " + employeeEntity);
		logger.info("Employee was recieved");
	}
}