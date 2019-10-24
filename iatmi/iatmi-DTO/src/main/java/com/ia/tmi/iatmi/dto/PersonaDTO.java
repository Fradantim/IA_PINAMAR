package com.ia.tmi.iatmi.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PersonaDTO {

	private Integer id; 
	
	private String nombre;
	
	private String apellido;
	
	private String dni;
	
	private String email;
	
	private String sexo;
	
	private Date fechaNacimiento;
	
	private Date fechaAlta;
	
	private String cbu;
	
	private String cuit;
	
	private List<String> roles;

	public PersonaDTO() {}
	
	public PersonaDTO(Integer id, String nombre, String apellido, String dni, String email, String sexo, Date fechaNacimiento,
			Date fechaAlta) {
		this(nombre, apellido, dni ,email, sexo, fechaNacimiento,fechaAlta);
		this.setId(id);
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
	
	public PersonaDTO(Integer id, String nombre, String apellido, String dni, String email, String sexo,
			Date fechaNacimiento, Date fechaAlta, String cbu, String cuit, List<String> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaAlta = fechaAlta;
		this.cbu = cbu;
		this.cuit = cuit;
		this.roles = roles;
	}

	public void addRol(String rol) {
		if (roles == null) roles = new ArrayList<String>();
		roles.add(rol);
	}

	@Override
	public String toString() {
		return "PersonaDTO [nombre=" + nombre + ", id=" + getId() + "]";
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
}
