package com.ia.tmi.iatmi.remoteEndpoint.presentismoEndpoint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
	
	private final static DateFormat GET_REPORTE_DATE_FORMATER= new SimpleDateFormat("yyyy-mm-dd");
	
	private static final Logger logger = LoggerFactory.getLogger(PresentismoFicheroConsumer.class);
	
	public void altaEmpleado(Persona persona) {
		CrearEmpleadoPresentismoRequest request = new CrearEmpleadoPresentismoRequest(persona, CUIL, EmpleadoPresentismoTypeEnum.MENSUAL);
		logger.debug("Enviando alta de Empleado a sistema de presentismo: "+request);
		
		CrearEmpleadoPresentismoResponse response = getRestTemplate().postForObject(crearEmpleadoUrl, request, CrearEmpleadoPresentismoResponse.class);
		logger.debug("Respuesta recibida: "+ response);
		
		persona.setIdSistemaPresentismo(response.getId().toString());
	}
	
	public void ficharIngreso(Fichero fichero) {
		fichar(fichero, FicharPresentismoRequestType.INGRESO);
	}
	
	public void ficharEgreso(Fichero fichero) {
		fichar(fichero, FicharPresentismoRequestType.EGRESO);
	}
	
	public void fichar(Fichero fichero, FicharPresentismoRequestType type) {
		FicharPresentismoRequest request = new FicharPresentismoRequest(fichero, type);
		logger.debug("Enviando "+ type +" a sistema de presentismo: "+request);
		
		FicharPresentismoResponse response = getRestTemplate().postForObject(crearEmpleadoUrl, request, FicharPresentismoResponse.class);
		
		logger.debug("Respuesta recibida: "+ response);
	}
	
	public void getHs(Persona persona, Date fechaDesde, Date fechaHasta) {
		logger.debug("Pidierndo reportes de Persona "+ persona +" a sistema de presentismo");
		
		String url = getHsUrl(persona, fechaDesde, fechaHasta);
		
		//TODO mapear respuesta
		Object response = getRestTemplate().getForObject(getHsUrl(persona, fechaDesde, fechaHasta), Object.class);
		
		logger.debug("Respuesta recibida: "+ response);
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
		//url += "?employeeId={employeeId}&from={from}&to={to}";
		
		url = replaceTagInUrl(url, employeeIdTag, persona.getIdSistemaPresentismo());
		url = replaceTagInUrl(url, fromTag, GET_REPORTE_DATE_FORMATER.format(fechaDesde));
		url = replaceTagInUrl(url, toTag, GET_REPORTE_DATE_FORMATER.format(fechaHasta));
				
		return url;
	}
	
	private String replaceTagInUrl(String url, String tag, String value) {
		return url.replaceAll("{"+tag+"}", value);
	}
}