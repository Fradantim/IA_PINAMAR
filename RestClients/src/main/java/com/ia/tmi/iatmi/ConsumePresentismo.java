package com.ia.tmi.iatmi;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ia.tmi.iatmi.persistence.entities.Fichero;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.remoteEndpoint.presentismoEndpoint.PresentismoFicheroConsumer;

@SpringBootApplication
@ComponentScan("com.ia.tmi.iatmi.remoteEndpoint.presentismoEndpoint")
public class ConsumePresentismo implements CommandLineRunner{
	
	@Autowired
	private PresentismoFicheroConsumer presentismoConsumer;
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumePresentismo.class, args).close();;
	}

	@Override
	public void run(String... args) throws Exception {
		String date= new SimpleDateFormat("dd HHmmss").format(new Date());
		String cuit = "20"+date.replaceAll(" ", "")+"7";
		Persona persona = new Persona("Franco", "GIM MOCK TEST "+date, "", "", "", null, 0F, "", cuit);
	
		presentismoConsumer.altaEmpleado(persona);		
		
		Date fechaIngreso, fechaEgreso;
		Fichero fichero ;
		
		fechaIngreso = new SimpleDateFormat("yyyyMMdd HHmmSS").parse("20191022 090000");
		fechaEgreso = new SimpleDateFormat("yyyyMMdd HHmmSS").parse("20191022 180000");
		
		fichero = new Fichero(persona, fechaIngreso , fechaEgreso);
		
		presentismoConsumer.ficharIngreso(fichero);
		presentismoConsumer.ficharEgreso(fichero);
		
		fechaIngreso = new SimpleDateFormat("yyyyMMdd HHmmSS").parse("20191023 090000");
		fechaEgreso = new SimpleDateFormat("yyyyMMdd HHmmSS").parse("20191023 180000");
		
		fichero = new Fichero(persona, fechaIngreso , fechaEgreso);
		
		presentismoConsumer.ficharIngreso(fichero);
		presentismoConsumer.ficharEgreso(fichero);
		
		presentismoConsumer.getHs(persona,
				new SimpleDateFormat("yyyyMMdd HHmmSS").parse("20191001 090000"),
				new SimpleDateFormat("yyyyMMdd HHmmSS").parse("20191230 180000"));
		
		
	}		
}
