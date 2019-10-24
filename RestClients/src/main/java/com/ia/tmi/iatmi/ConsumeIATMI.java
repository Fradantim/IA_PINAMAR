package com.ia.tmi.iatmi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ia.tmi.iatmi.remoteEndpoint.iatmiEndpoint.IaTMIFicheroConsumer;
import com.ia.tmi.iatmi.remoteEndpoint.iatmiEndpoint.banco.IaTMFBancoConsumer;
import com.ia.tmi.iatmi.remoteEndpoint.iatmiEndpoint.banco.TransferenciaMock;
import com.ia.tmi.iatmi.remoteEndpoint.iatmiEndpoint.banco.TransferenciaRequest;

@SpringBootApplication
@ComponentScan("com.ia.tmi.iatmi.remoteEndpoint.iatmiEndpoint")
public class ConsumeIATMI implements CommandLineRunner{
	
	@Autowired
	private IaTMIFicheroConsumer ficheroConsumer;
	
	@Autowired
	private IaTMFBancoConsumer bancarioConsumer;
	
	@Autowired
	private TransferenciaMock mock;
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumeIATMI.class, args).close();;
	}

	@Override
	public void run(String... args) throws Exception {
		//ficheroConsumer.ficharEgreso(24, "EMPLEADO");
		//System.out.println("Fichado Egreso!");
		
		//ficheroConsumer.ficharEgreso(24, "SOCIO");
		//System.out.println("Fichado Egreso!");
		
		List<TransferenciaRequest> tranferencias = mock.cargarTransferenciasARealizar();
		for (TransferenciaRequest transferenciaRequest : tranferencias) {			
			System.out.println(transferenciaRequest.toString());
			bancarioConsumer.transferenciaBancaria(transferenciaRequest.getOrigenCBU(), transferenciaRequest.getDestinoCBU(), transferenciaRequest.getAmount());
			System.out.println("Tranferencia realizada.");
		}
		
	}	
		//ficheroConsumer.ficharEgreso(24, "EMPLEADO");
		//System.out.println("Fichado Egreso!");
	
	
}
