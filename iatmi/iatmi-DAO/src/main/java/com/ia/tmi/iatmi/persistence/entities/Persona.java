package com.ia.tmi.iatmi.persistence.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ia.tmi.iatmi.persistence.entities.RolPersona.RolPersonaEnum;
import com.ia.tmi.iatmi.persistence.utils.DateAndCalendarUtil;

@Entity
public class Persona {
	
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
	
	@Column
	private String CUIT;
	
	@Column
	private String CBU;
	
	@Column
	private String idSistemaPresentismo;

	@ManyToOne
	private Habilitacion habilitacion;

	@ManyToOne
	private TipoEmpleado tipoEmpleado;
	
	@OneToMany
	private List<Liquidacion> liquidacion;

	@ManyToMany(fetch=FetchType.EAGER)
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
	
	public Persona(String nombre, String apellido, String dni, String email, String sexo, Date fechaNacimiento, String CUIT, String CBU) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaAlta = new Date();
		this.CBU=CBU;
		this.CUIT=CUIT;
	}

	public Persona(String nombre, String apellido, String dni, String email, String sexo, Date fechaNacimiento,
			Float sueldoBasicoCostoHora, String CBU, String CUIT) {
		this(nombre, apellido, dni, email, sexo, fechaNacimiento);
		this.sueldoBasicoCostoHora = sueldoBasicoCostoHora;
		this.CBU=CBU;
		this.CUIT=CUIT;
	}
	
	public static Persona toPersona(Integer id,String apellido,String dni,String mail, Date fechaAlta, Date fechaNacimiento, String nombre, String sexo,Float sueldo,Integer idHabilitacion, Integer idTipoEmpleado) {
		Persona persona = new Persona(nombre, apellido, dni, mail, sexo, fechaNacimiento);
		persona.setId(id);
		persona.setSueldoBasicoCostoHora(sueldo);
		if(idHabilitacion != null) {			
			Habilitacion habilitacion = new Habilitacion();
			habilitacion.setId(idHabilitacion);
			persona.setHabilitacion(habilitacion);
		}
		if(idTipoEmpleado != null) {			
			TipoEmpleado tipoEmpleado = new TipoEmpleado();
			tipoEmpleado.setId(idTipoEmpleado);
			persona.setTipoEmpleado(tipoEmpleado);
		}
		return persona;
	}

	public void addRol(RolPersona rol) {
		if (roles == null)
			roles = new HashSet<RolPersona>();
		roles.add(rol);
	}

	public void removeRol(RolPersona rol) {
		if (roles != null)
			roles.remove(rol);
	}

	public Boolean hasRol(RolPersona rol) {
		if (roles != null)
			return roles.contains(rol);
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
			if (!getTipoEmpleado().getEsMensual() && getTipoEmpleado().getEsProfesor()) {
				for (Fichero fichero : fichadas) {
					if (fichero.getActivo()
							&& DateAndCalendarUtil.mesDelAnio(fichero.getFechaIngreso()) == mes
							&& fichero.getRol().equals(RolPersonaEnum.EMPLEADO.getRol())) {
						horas+=fichero.getCantidadDeHoras();
					}
				}
			}
			return horas;
		}
	}

	public List<Liquidacion> getLiquidacion() {
		return liquidacion;
	}

	public void setLiquidacion(List<Liquidacion> liquidacion) {
		this.liquidacion = liquidacion;
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
