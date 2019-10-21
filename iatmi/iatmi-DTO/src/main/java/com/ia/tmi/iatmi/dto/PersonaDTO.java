package com.ia.tmi.iatmi.dto;

public class PersonaDTO {

	private String nombre;
	
	private int id;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PersonaDTO(int id, String nombre) {
		this.nombre = nombre;
		this.id = id;
	}

	@Override
	public String toString() {
		return "PersonaDTO [nombre=" + nombre + ", id=" + id + "]";
	}
}
