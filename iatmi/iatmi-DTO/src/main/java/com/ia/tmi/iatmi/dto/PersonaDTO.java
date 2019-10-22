package com.ia.tmi.iatmi.dto;

import java.util.Date;


public abstract class PersonaDTO {

	private Integer id; 
	
	private String nombre;
	
	private String apellido;
	
	private String dni;
	
	private String email;
	
	private String sexo;
	
	private Date fechaNacimiento;
	
	private Date fechaAlta;

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


	public PersonaDTO(String nombre, String apellido, String dni, String email, String sexo, Date fechaNacimiento,
			Date fechaAlta) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaAlta = fechaAlta;
	}

	@Override
	public String toString() {
		return "PersonaDTO [nombre=" + nombre + ", id=" + id + "]";
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
