package com.ia.tmi.iatmi.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.RolPersona;
import com.ia.tmi.iatmi.persistence.repository.RolPersonaRepository;

@Service
public class RolPersonaService {
	
	public enum RolPersonaEnum{
		SOCIO("SOCIO"),
		EMPLEADO("EMPLEADO");
				
		private RolPersonaEnum(String key) {
			this.key= key;
		}
		
		private String key;
		private RolPersona rol;
		
		public String getKey() { return key; }
		public RolPersona getRol() { return rol; }
		public void setRol(RolPersona rol) { this.rol=rol;}
		
		public static RolPersonaEnum getByKey (String key) {
			for(RolPersonaEnum rol: values()) {
				if(rol.getKey().equals(key)) {
					return rol;
				}
			}
			throw new IllegalArgumentException("No se encontro un rol con nombre "+key);
		}
	}
	
	@Autowired
	private RolPersonaRepository rolRepo;
	
	public List<RolPersona> findAll(){
		return rolRepo.findAll();
	}
	
	public Optional<RolPersona> findById(Integer id){
		return rolRepo.findById(id);
	}
	
	public RolPersona save(RolPersona rol){
		return rolRepo.save(rol);
	}
}
