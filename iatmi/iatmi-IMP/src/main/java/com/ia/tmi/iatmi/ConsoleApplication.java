package com.ia.tmi.iatmi;

import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ia.tmi.iatmi.persistence.entities.Empleado;
import com.ia.tmi.iatmi.persistence.entities.Socio;
import com.ia.tmi.iatmi.persistence.entities.TipoEmpleado;
import com.ia.tmi.iatmi.persistence.service.EmpleadoService;
import com.ia.tmi.iatmi.persistence.service.SocioService;


@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner{

	@Autowired
	private SocioService socioService;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO proximamente para app de consola / batch ?
		// Por ahora para test
		
		testInsertPersona();
	}
	
	public static void main(String[] args) throws Exception {
        //disabled banner, don't want to see the spring logo
		SpringApplication.run(ConsoleApplication.class, args);
    }
    
	
	public void testInsertPersona() {
		Date hasta = Date.from(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().plusDays(1)
				.atZone(ZoneId.systemDefault()).toInstant());
		Socio socio = new Socio("Franco", "T", "373", "a@a.com", "m", new Date(), new Date(), hasta);

		socioService.save(socio);
		
		TipoEmpleado tipoEmp = null;
		
		Empleado empleado = new Empleado("Franco", "T", "373", "a@a.com", "m", new Date(), null, tipoEmp, 100F);

		empleadoService.save(empleado);
		
		System.out.println("IN");
	}
	
}