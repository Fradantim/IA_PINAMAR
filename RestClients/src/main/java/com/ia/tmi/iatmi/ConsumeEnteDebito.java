package com.ia.tmi.iatmi;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ia.tmi.iatmi.persistence.entities.Factura;
import com.ia.tmi.iatmi.persistence.entities.FacturaDetalle;
import com.ia.tmi.iatmi.persistence.entities.Pago;
import com.ia.tmi.iatmi.persistence.entities.Pase;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.remoteEndpoint.entidadDebitoEndpoint.EntidadDebitoConsumer;

@SpringBootApplication
@ComponentScan("com.ia.tmi.iatmi.remoteEndpoint.entidadDebitoEndpoint")
public class ConsumeEnteDebito implements CommandLineRunner{
	
	@Autowired
	private EntidadDebitoConsumer entDebConsumer;
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumeEnteDebito.class, args).close();;
	}

	@Override
	public void run(String... args) throws Exception {
		String date= new SimpleDateFormat("dd HHmmss").format(new Date());
		String cuit = "20"+date.replaceAll(" ", "")+"7";
		Persona persona = new Persona("Franco", "GIM MOCK TEST "+date, "", "", "", null, 0F, "", cuit);
	
		Pase pase = new Pase(30, "MENSUAL", 10F);
		
		Factura factura = new Factura(persona);
		
		FacturaDetalle detalle = new FacturaDetalle(pase, factura);
		
		factura.addFacturaDetalle(detalle);
		
		Pago pago = new Pago(factura);
		
		String cardNumber = "2018180353113356";
		String expirationDateMonth = "10";
		String expirationDateYear = "2029";
		String securityCode = "366";
		
		entDebConsumer.pagarFactura(pago, cardNumber, expirationDateMonth, expirationDateYear, securityCode);
	}		
}
