package com.ia.tmi.iatmi.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RolPersona {

	public enum RolPersonaEnum {
		SOCIO, EMPLEADO;
		
		private RolPersona rol;

		public RolPersona getRol() {return rol;}

		public void setRol(RolPersona rol) {this.rol = rol;}
	}

	@Id
	private String id;

	public RolPersona(String id) {
		this.id=id;
	}
	
	public RolPersona() { }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolPersona other = (RolPersona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
