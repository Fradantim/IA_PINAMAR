package com.ia.tmi.iatmi.remoteEndpoint;

import java.util.Arrays;

import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.ia.tmi.iatmi.config.LoggingRequestInterceptor;

public abstract class EndpointConsumer {

	protected RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
		LoggingRequestInterceptor interceptor = new LoggingRequestInterceptor();
		restTemplate.setInterceptors(Arrays.asList(new LoggingRequestInterceptor()));
		restTemplate.setErrorHandler(interceptor);
		return restTemplate;
	}
}
