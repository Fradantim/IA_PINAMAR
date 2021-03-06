package com.ia.tmi.iatmi.controller;

import java.util.List;

import com.ia.tmi.iatmi.dto.FacturaDTO;
import com.ia.tmi.iatmi.dto.FichaMedicaDTO;
import com.ia.tmi.iatmi.dto.PersonaDTO;

public interface PersonaController {
	public List<PersonaDTO> findAll();
	
	public PersonaDTO altaSocio(PersonaDTO persona);
	
	public PersonaDTO altaEmpleado(PersonaDTO persona, Float sueldoBasicoCostoHora, Integer idTipoEmpleado);
	
	public FacturaDTO asignarPase(Integer idPersona, Integer idPase);
	
	public List<PersonaDTO> findEmpleados();
	
	public List<PersonaDTO> findProfesores();
	
	public List<PersonaDTO> findSocios();
	
	public void addFichaMedica(FichaMedicaDTO fichaMedica, Integer idPersona);
	
}
