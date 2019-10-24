package com.ia.tmi.iatmi.remoteEndpoint;

import java.util.Arrays;

import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.ia.tmi.iatmi.config.LoggingRequestInterceptor;

public abstract class EndpointConsumer {

	protected RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
		restTemplate.setInterceptors(Arrays.asList(new LoggingRequestInterceptor()));
		return restTemplate;
	}
}
