package com.ia.tmi.iatmi.remoteEndpoint.presentismoEndpoint;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.exception.RemoteEndpointException;
import com.ia.tmi.iatmi.persistence.entities.Fichero;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.remoteEndpoint.EndpointConsumer;
import com.ia.tmi.iatmi.remoteEndpoint.presentismoEndpoint.CrearEmpleadoPresentismoRequest.EmpleadoPresentismoTypeEnum;
import com.ia.tmi.iatmi.remoteEndpoint.presentismoEndpoint.FicharPresentismoRequest.FicharPresentismoRequestType;

@Service
public class PresentismoFicheroConsumer extends EndpointConsumer {
	
	@Value("${presentimos.fichar.url}")
	private String ficharUrl;
	
	@Value("${presentismos.crearEmpleado.url}")
	private String crearEmpleadoUrl;
	
	@Value("${presentismos.getReporte.url}")
	private String getReporteUrl;
	
	@Value("${iatmi.CUIL}")
	private String CUIL;
	
	private static final Logger logger = LoggerFactory.getLogger(EndpointConsumer.class);
	
	public void altaEmpleado(Persona persona) {
		try {
			CrearEmpleadoPresentismoRequest request = new CrearEmpleadoPresentismoRequest(persona, CUIL, EmpleadoPresentismoTypeEnum.MENSUAL);
			logger.debug("Enviando alta de Empleado a sistema de presentismo: "+request);
			
			CrearEmpleadoPresentismoResponse response = getRestTemplate().postForObject(crearEmpleadoUrl, request, CrearEmpleadoPresentismoResponse.class);
			logger.debug("Respuesta recibida: "+ response);
			
			persona.setIdSistemaPresentismo(response.getId().toString());
		} catch (Exception e) {
			throw new RemoteEndpointException("Error de comunicacion al consumir el servicio de Presentismo. "+e.getMessage());
		}
	}
	
	public void ficharIngreso(Fichero fichero) {
		fichar(fichero, FicharPresentismoRequestType.INGRESO, fichero.getFechaIngreso());
	}
	
	public void ficharEgreso(Fichero fichero) {
		fichar(fichero, FicharPresentismoRequestType.EGRESO, fichero.getFechaEgreso());
	}
	
	public void fichar(Fichero fichero, FicharPresentismoRequestType type, Date fecha) {
		try {
			FicharPresentismoRequest request = new FicharPresentismoRequest(fichero, type, fecha);
			logger.debug("Enviando "+ type +" a sistema de presentismo: "+request);
			
			FicharPresentismoResponse response = getRestTemplate().postForObject(ficharUrl, request, FicharPresentismoResponse.class);
			
			logger.debug("Respuesta recibida: "+ response);
		} catch (Exception e) {
			throw new RemoteEndpointException("Error de comunicacion al consumir el servicio de Presentismo. "+e.getMessage());
		}
	}
	
	public Integer getHs(Persona persona, Date fechaDesde, Date fechaHasta) {
		try {
			logger.debug("Pidierndo reportes de Persona "+ persona +" a sistema de presentismo");
					
			GerHsPresentismoResponse response = getRestTemplate().getForObject(getHsUrl(persona, fechaDesde, fechaHasta), GerHsPresentismoResponse.class);
			
			logger.debug("Respuesta recibida: "+ response);
			return response.getTotalHours();
		} catch (Exception e) {
			throw new RemoteEndpointException("Error de comunicacion al consumir el servicio de Presentismo. "+e.getMessage());
		}
	}
	
	private String getHsUrl(Persona persona, Date fechaDesde, Date fechaHasta) {
		String url = getReporteUrl;
		
		String employeeIdTag= "employeeId";
		String fromTag= "from";
		String toTag= "to";
		
		List<String> tags = Arrays.asList(employeeIdTag,fromTag,toTag);
		
		if(tags.size()>0) {
			url+="?";
			for(int i =0; i <tags.size(); i++) {
				if(i!=0) {
					url+="&";
				}
				url+=tags.get(i)+"={"+tags.get(i)+"}";
			}
		}
		
		url = replaceTagInUrl(url, employeeIdTag, persona.getCUIT()); //en employeeId va el cuit...
		url = replaceTagInUrl(url, fromTag, fechaDesde.toInstant().toString().substring(0,10));
		url = replaceTagInUrl(url, toTag, fechaHasta.toInstant().toString().substring(0,10));
				
		return url;
	}
	
	private String replaceTagInUrl(String url, String tag, String value) {
		return url.replace("{"+tag+"}", value);
	}
}