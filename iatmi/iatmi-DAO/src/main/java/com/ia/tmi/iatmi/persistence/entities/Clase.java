package com.ia.tmi.iatmi.persistence.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Clase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String nombre;
	
	@ManyToMany
	private Set<Persona> profesores;

	public Clase(String nombre) {
		this.nombre = nombre;
	}
	
	public Clase() { }
	
	public void addProfesor(Persona profesor) {
		if(profesores == null) profesores = new HashSet<Persona>();
		profesores.add(profesor);
	}
	
	public void removeProfesor(Persona profesor) {
		if(profesores != null)
			profesores.remove(profesor);
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

	public Set<Persona> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<Persona> profesores) {
		this.profesores = profesores;
	}
}
