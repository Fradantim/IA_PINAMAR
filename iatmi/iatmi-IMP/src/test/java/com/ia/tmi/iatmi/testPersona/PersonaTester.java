package com.ia.tmi.iatmi.testPersona;

import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ia.tmi.iatmi.persistence.entities.Clase;
import com.ia.tmi.iatmi.persistence.entities.Habilitacion;
import com.ia.tmi.iatmi.persistence.service.ClaseService;
import com.ia.tmi.iatmi.persistence.service.SocioService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {SocioService.class,SocioRepository.class})
//@ContextConfiguration(classes = {ClaseService.class})
//@ContextConfiguration
//@SpringBootTest
public class PersonaTester {

	/*@Autowired
	private SocioService socioService;

	@Autowired
	private ClaseService claseService;

	@Test
	public void testInsert() {
		Date hasta = Date.from(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().plusDays(1)
				.atZone(ZoneId.systemDefault()).toInstant());
		Habilitacion socio = new Habilitacion("Franco", "T", "373", "a@a.com", "m", new Date(), new Date(), hasta);

		// socioService.save(socio);

		Clase clase = new Clase("");
		claseService.save(clase);
		System.out.println("IN");
	}
	*/
}
