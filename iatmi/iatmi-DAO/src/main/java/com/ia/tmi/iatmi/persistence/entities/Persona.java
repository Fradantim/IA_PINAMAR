package com.ia.tmi.iatmi.persistence.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ia.tmi.iatmi.persistence.utils.DateAndCalendarUtil;

@Entity
public class Persona {

	public enum RolPersona {
		SOCIO, EMPLEADO;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String nombre;

	@Column
	private String apellido;

	@Column
	private String dni;

	@Column
	private String email;

	@Column
	private String sexo;

	@Column
	private Date fechaNacimiento;

	@Column
	private Date fechaAlta;

	@Column
	private Float sueldoBasicoCostoHora;

	@ManyToOne
	private Habilitacion habilitacion;

	@ManyToOne
	private TipoEmpleado tipoEmpleado;

	@ElementCollection(targetClass = RolPersona.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "PERSONA_ROL")
	@Column
	private Set<RolPersona> roles;

	@Column
	@OneToMany
	private List<Fichero> fichadas;

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
			Float sueldoBasicoCostoHora) {
		this(nombre, apellido, dni, email, sexo, fechaNacimiento);
		this.sueldoBasicoCostoHora = sueldoBasicoCostoHora;
	}

	public void addRol(RolPersona rol) {
		if (roles == null)
			roles = new HashSet<Persona.RolPersona>();
		roles.add(rol);
	}

	public void removeRol(RolPersona rol) {
		if (roles != null)
			roles.remove(rol);
	}

	public Boolean hasRol(RolPersona rol) {
		if (roles != null)
			roles.contains(rol);
		return false;
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

	public Habilitacion getHabilitacion() {
		return habilitacion;
	}

	public void setHabilitacion(Habilitacion habilitacion) {
		this.habilitacion = habilitacion;
	}

	public Set<RolPersona> getRoles() {
		return roles;
	}

	public void setRoles(Set<RolPersona> roles) {
		this.roles = roles;

	}

	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;

	}

	public List<Fichero> getFichadas() {
		return fichadas;
	}

	public void setFichadas(List<Fichero> fichadas) {
		this.fichadas = fichadas;
	}

	public int calcularHorasPorFichada(int mes) {
		int horas = 0;
		if (mes > 13 || mes < 1)
			return 0;
		else {
			if (!getTipoEmpleado().getEsMensual() && getTipoEmpleado().getEsProfresor()) {
				for (Fichero fichero : fichadas) {
					if (fichero.getActivo()) {
						if (DateAndCalendarUtil.mesDelAnio(fichero.getFechaIngreso()) == mes) {
							horas = DateAndCalendarUtil.restarHoras(fichero.getFechaIngreso(),
									fichero.getFechaEgreso());
						}
					}
				}
			}
			return horas;
		}
	}

}
