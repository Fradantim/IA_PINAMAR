package com.ia.tmi.iatmi.persistence.entities;

import java.util.Date;

public class Persona {
	
	private Integer id;

	private String nombre;

	private String apellido;

	private String dni;

	private String email;

	private String sexo;

	private Date fechaNacimiento;

	private Date fechaAlta;

	private Float sueldoBasicoCostoHora;
	
	private String CUIT;
	
	private String CBU;
	
	private String idSistemaPresentismo;

	public Persona() {
	}

	public Persona(String nombre, String apellido, String dni, String email, String sexo, Date fechaNacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaAlta = new Date();
	}

	public Persona(String nombre, String apellido, String dni, String email, String sexo, Date fechaNacimiento,
			Float sueldoBasicoCostoHora, String CBU, String CUIT) {
		this(nombre, apellido, dni, email, sexo, fechaNacimiento);
		this.sueldoBasicoCostoHora = sueldoBasicoCostoHora;
		this.CBU=CBU;
		this.CUIT=CUIT;
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

	public Float getSueldoBasicoCostoHora() {
		return sueldoBasicoCostoHora;
	}

	public void setSueldoBasicoCostoHora(Float sueldoBasicoCostoHora) {
		this.sueldoBasicoCostoHora = sueldoBasicoCostoHora;
	}

	public String getCUIT() {
		return CUIT;
	}

	public void setCUIT(String cUIT) {
		CUIT = cUIT;
	}

	public String getCBU() {
		return CBU;
	}

	public void setCBU(String cBU) {
		CBU = cBU;
	}
	
	public String getIdSistemaPresentismo() {
		return idSistemaPresentismo;
	}

	public void setIdSistemaPresentismo(String idSistemaPresentismo) {
		this.idSistemaPresentismo = idSistemaPresentismo;
	}
}
