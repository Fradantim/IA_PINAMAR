package com.ia.tmi.iatmi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ia.tmi.iatmi.remoteEndpoint.iatmiEndpoint.IaTMIFicheroConsumer;

@SpringBootApplication
@ComponentScan("com.ia.tmi.iatmi.remoteEndpoint.iatmiEndpoint")
public class ConsumeIATMI implements CommandLineRunner{
	
	@Autowired
	private IaTMIFicheroConsumer ficheroConsumer;
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumeIATMI.class, args).close();;
	}

	@Override
	public void run(String... args) throws Exception {
		//ficheroConsumer.ficharEgreso(24, "EMPLEADO");
		//System.out.println("Fichado Egreso!");
		
		//ficheroConsumer.ficharEgreso(24, "EMPLEADO");
		//System.out.println("Fichado Egreso!");
	}	
}