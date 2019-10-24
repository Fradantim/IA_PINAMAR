package com.ia.tmi.iatmi.remoteEndpoint.presentismoEndpoint;

import com.ia.tmi.iatmi.persistence.entities.Persona;

public class CrearEmpleadoPresentismoRequest {
	
	public enum EmpleadoPresentismoTypeEnum{
		 DIARIO, SEMANAL, QUINCENAL, MENSUAL;
	}

	private String cuit;
	private String clientCuit;
	private String firstName;
	private String lastName;
	private String type;

	public CrearEmpleadoPresentismoRequest() {}

	public CrearEmpleadoPresentismoRequest(String cuit, String clienteCuit, String firstName, String lastName, EmpleadoPresentismoTypeEnum type) {
		this.cuit = cuit;
		this.clientCuit = clienteCuit;
		this.firstName = firstName;
		this.lastName = lastName;
		this.type = type.name();
	}
	
	public CrearEmpleadoPresentismoRequest(Persona persona, String CUIT, EmpleadoPresentismoTypeEnum type) {
		this(persona.getCUIT(),CUIT, persona.getNombre(), persona.getApellido(), type);
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getClientCuit() {
		return clientCuit;
	}

	public void setClientCuit(String clienteCuit) {
		this.clientCuit = clienteCuit;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CrearEmpleadoPresentismoRequest [cuit=" + cuit + ", clientCuit=" + clientCuit + ", firstName="
				+ firstName + ", lastName=" + lastName + ", type=" + type + "]";
	}	
}
