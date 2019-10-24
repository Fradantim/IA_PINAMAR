package com.ia.tmi.iatmi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ia.tmi.iatmi.remoteEndpoint.quoteEndpoint.Quote;
import com.ia.tmi.iatmi.remoteEndpoint.quoteEndpoint.QuoteConsumer;

@SpringBootApplication
@ComponentScan("com.ia.tmi.iatmi.remoteEndpoint.quoteEndpoint")
public class ConsumeGetQuote implements CommandLineRunner{
	
	@Autowired
	private QuoteConsumer quoteConsumer;
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumeGetQuote.class, args).close();;
	}

	@Override
	public void run(String... args) throws Exception {
		Quote quoteRecuperado = quoteConsumer.getQuote();
		System.out.println("Quote recuperado: "+quoteRecuperado);
	}	
}