package com.idemia.ws.client.config;

import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;

public class SOAPTemplate extends WebServiceGatewaySupport {

	public Object exchange(String url, Object request, boolean authRequired) {
		WebServiceTemplate template = getWebServiceTemplate();
		if (authRequired) {
			template.setInterceptors(new ClientInterceptor[] { wsSecurityInterceptor() });
		}
		return template.marshalSendAndReceive(url, request);
	}

	public Wss4jSecurityInterceptor wsSecurityInterceptor() {
		Wss4jSecurityInterceptor wss4jSecurityInterceptor = new Wss4jSecurityInterceptor();
		wss4jSecurityInterceptor.setSecurementActions(WSHandlerConstants.USERNAME_TOKEN);
		wss4jSecurityInterceptor.setSecurementPasswordType(WSConstants.PW_TEXT);
		wss4jSecurityInterceptor.setSecurementUsername("wsuser");
		wss4jSecurityInterceptor.setSecurementPassword("wspassword");
		return wss4jSecurityInterceptor;
	}
}