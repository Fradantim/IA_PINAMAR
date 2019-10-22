package com.ia.tmi.iatmi.persistence.repository;

import org.springframework.transaction.annotation.Transactional;

import com.ia.tmi.iatmi.persistence.entities.Empleado;

@Transactional
public interface EmpleadoRepository extends PersonaRepository<Empleado> {

}
