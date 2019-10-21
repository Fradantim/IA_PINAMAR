package com.ia.tmi.iatmi.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Empleado {
	
	@Id
	private Integer legajo;
	
	@Column
	private Date fechaAlta;
}
