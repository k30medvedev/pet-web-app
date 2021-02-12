package com.mastery.java.jms.consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {
	private static final Logger logger = LogManager.getLogger(JmsConsumer.class.getName());

//	@Autowired
//	private MessageStorage customerStorage;
//
//	@JmsListener(destination = "${activemq.queue}", containerFactory="jsaFactory")
//	public void receive(Customer customer){
//		System.out.println("Recieved Message: " + customer);
//		customerStorage.add(customer);
//		logger.info("Employee was recieved");
	//}
}