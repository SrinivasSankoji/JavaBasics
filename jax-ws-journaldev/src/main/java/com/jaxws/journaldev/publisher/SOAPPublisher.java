package com.jaxws.journaldev.publisher;

import javax.xml.ws.Endpoint;

import com.jaxws.journaldev.service.PersonServiceImpl;

public class SOAPPublisher {

		public static void main(String[] args) {
			 Endpoint.publish("http://localhost:8888/ws/person", new PersonServiceImpl()); 
		}
}
