package com.idemia.ws.client.services;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

@WebService(serviceName = "TestProductService")
@Service
public interface ClientProduct {
	
	@WebMethod()
	@WebResult(name ="result")
	public String testProduct();
}
