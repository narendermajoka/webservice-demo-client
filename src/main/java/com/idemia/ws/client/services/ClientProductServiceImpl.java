package com.idemia.ws.client.services;

import javax.xml.bind.JAXBElement;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idemia.ws.client.config.SOAPTemplate;
import com.idemia.ws.services.GetProductById;
import com.idemia.ws.services.GetProductByIdResponse;

@Service
@Logging
public class ClientProductServiceImpl implements ClientProduct {

	@Autowired
	private SOAPTemplate soapTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public String testProduct() {
		GetProductById request = new GetProductById();
		request.setProductId(1);
		GetProductByIdResponse res = null;

		JAXBElement<GetProductByIdResponse> response = (JAXBElement<GetProductByIdResponse>) soapTemplate
				.exchange("http://localhost:8080/services/productService", request, true);
		res = response.getValue();
		return res.getProduct().getName();
	}
}
