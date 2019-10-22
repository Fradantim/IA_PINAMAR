/**
 * 
 */
package com.ia.tmi.iatmi.persistence.repository;

import org.springframework.transaction.annotation.Transactional;

import com.ia.tmi.iatmi.persistence.entities.Socio;

/**
 * @author c02536
 *
 */
@Transactional
public interface SocioRepository extends PersonaRepository<Socio> {

}
