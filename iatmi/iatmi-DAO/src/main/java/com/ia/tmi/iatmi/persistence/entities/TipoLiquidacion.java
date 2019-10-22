package com.ia.tmi.iatmi.persistence.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_liquidacion")
public abstract class TipoLiquidacion {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String descripcion;
	
	
	@Column
	private Float valorPorcentaje;
	
	@Column
	private boolean activo;
}
