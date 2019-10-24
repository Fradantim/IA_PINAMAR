package com.ia.tmi.iatmi.remoteEndpoint.presentismoEndpoint;

import com.ia.tmi.iatmi.persistence.entities.Persona;

public class CrearEmpleadoPresentismoRequest {

	private String cuit;
	private String clienteCuit;
	private String firstName;
	private String lastName;
	
	public CrearEmpleadoPresentismoRequest() {}

	public CrearEmpleadoPresentismoRequest(String cuit, String clienteCuit, String firstName, String lastName) {
		this.cuit = cuit;
		this.clienteCuit = clienteCuit;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public CrearEmpleadoPresentismoRequest(Persona persona, String CUIT) {
		this.cuit = persona.getCUIT();
		this.clienteCuit = CUIT;
		this.firstName = persona.getNombre();
		this.lastName = persona.getApellido();
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getClienteCuit() {
		return clienteCuit;
	}

	public void setClienteCuit(String clienteCuit) {
		this.clienteCuit = clienteCuit;
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

	@Override
	public String toString() {
		return "CrearEmpleadoPresentismoRequest [cuit=" + cuit + ", clienteCuit=" + clienteCuit + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}
}
