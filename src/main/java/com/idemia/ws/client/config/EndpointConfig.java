package com.idemia.ws.client.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.idemia.ws.client.services.ClientProductServiceImpl;

@Configuration
public class EndpointConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.idemia.ws.services");
		return marshaller;
	}

	@Bean
	public SOAPTemplate soapTemplate(Jaxb2Marshaller marshaller) {
		SOAPTemplate client = new SOAPTemplate();
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	@Bean
	public Endpoint testProductServiceEndpoint(SpringBus bus,ClientProductServiceImpl service) {
		EndpointImpl endpoint = new EndpointImpl(bus, service);
		endpoint.publish("/clientProductService");
		return endpoint;
	}

}
