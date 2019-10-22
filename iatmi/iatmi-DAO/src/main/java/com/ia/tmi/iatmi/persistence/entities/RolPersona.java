package com.ia.tmi.iatmi.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RolPersona {
	
	//TODO BORRAR ENTIDAD, HORA ESTA EN ENUM
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id; 
	
	@Column
	private String nombre;
	
	public RolPersona() { }
	
	public RolPersona(String nombre) {
		this.nombre=nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
