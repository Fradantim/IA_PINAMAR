package com.ia.tmi.iatmi.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class LiquidacionItem {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String descripcion;

	@Column
	private Float valor;

	@Column
	private Boolean activo;

	@Column
	private Boolean sueldoBasico;

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<TipoLiquidacion> tiposLiquidaciones;

	// @ManyToMany(cascade=CascadeType.PERSIST,fetch = FetchType.LAZY)
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "liquidacion_item_tipo_empleados", joinColumns = @JoinColumn(name = "liquidacion_item_id"), inverseJoinColumns = @JoinColumn(name = "tipo_empleados_id"))
	private List<TipoEmpleado> tipoEmpleados;

	public LiquidacionItem(String descripcion, Float valor, Boolean sueldoBasico) {
		this.descripcion = descripcion;
		this.valor = valor;
		this.sueldoBasico = sueldoBasico;
		this.activo = true;
	}

	public LiquidacionItem(Integer id, String descripcion, Float valor, Boolean sueldoBasico) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.valor = valor;
		this.sueldoBasico = sueldoBasico;
	}

	public LiquidacionItem() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Boolean isActivo() {
		return activo;
	}

	public Boolean isSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(Boolean sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	public float calcularRemunerativo() {
		float montoRemunerativo = 0;
		for (TipoLiquidacion tipoLiquidacion : getTiposLiquidaciones()) {
			if (tipoLiquidacion instanceof TipoLiquidacionRemunerativa) {
				TipoLiquidacionRemunerativa tipo = (TipoLiquidacionRemunerativa) tipoLiquidacion;
				montoRemunerativo = montoRemunerativo + tipo.getValor();
			}
		}
		return montoRemunerativo;
	}

	public float calcularNoRemunerativo() {
		float montoNoRemunerativo = 0;
		for (TipoLiquidacion tipoLiquidacion : getTiposLiquidaciones()) {
			if (tipoLiquidacion instanceof TipoLiquidacionNoRemunerativa) {
				TipoLiquidacionNoRemunerativa tipo = (TipoLiquidacionNoRemunerativa) tipoLiquidacion;
				montoNoRemunerativo = montoNoRemunerativo + tipo.getValor();
			}
		}
		return montoNoRemunerativo;
	}

	public float calcularDescuento(float montoBruto) {
		float montoDescuento = 0;
		for (TipoLiquidacion tipoLiquidacion : getTiposLiquidaciones()) {
			if (tipoLiquidacion instanceof TipoLiquidacionDescuento) {
				TipoLiquidacionDescuento tipo = (TipoLiquidacionDescuento) tipoLiquidacion;
				montoDescuento = montoDescuento + (montoBruto * tipo.getValor());
			}
		}
		return montoDescuento;
	}

	public List<TipoLiquidacion> getTiposLiquidaciones() {
		return tiposLiquidaciones;
	}

	public void setTiposLiquidaciones(List<TipoLiquidacion> tiposLiquidaciones) {
		this.tiposLiquidaciones = tiposLiquidaciones;
	}

	public void addTipoLiquidacion(TipoLiquidacion tipoLiquidacion) {
		if (tiposLiquidaciones == null)
			tiposLiquidaciones = new ArrayList<TipoLiquidacion>();
		tiposLiquidaciones.add(tipoLiquidacion);
	}

	public void addTipoEmpleado(TipoEmpleado tipoEmpleado) {
		if (tipoEmpleados == null)
			tipoEmpleados = new ArrayList<TipoEmpleado>();
		tipoEmpleados.add(tipoEmpleado);
	}
}
