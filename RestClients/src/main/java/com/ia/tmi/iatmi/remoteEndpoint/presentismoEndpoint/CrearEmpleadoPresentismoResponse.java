package com.ia.tmi.iatmi.remoteEndpoint.presentismoEndpoint;

public class CrearEmpleadoPresentismoResponse {

	private Integer id;
	private String cuit,name;
	
	public CrearEmpleadoPresentismoResponse() {}

	public CrearEmpleadoPresentismoResponse(Integer id, String cuit, String name) {
		this.id = id;
		this.cuit = cuit;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "CrearEmpleadoPresentismoResponse [id=" + id + ", cuit=" + cuit + ", name=" + name + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
