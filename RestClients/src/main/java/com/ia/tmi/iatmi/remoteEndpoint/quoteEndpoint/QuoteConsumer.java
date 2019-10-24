package com.ia.tmi.iatmi.remoteEndpoint.quoteEndpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuoteConsumer {
	
	@Value("${quote.url}")
	private String url;

	public Quote getQuote() {
		return new RestTemplate().getForObject(url, Quote.class);
	}
}