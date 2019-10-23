package com.ia.tmi.iatmi.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ia.tmi.iatmi.persistence.entities.Liquidacion;

@Repository
public interface LiquidacionRepository extends JpaRepository<Liquidacion, Integer> {

	@Query(value = "select p.* from liquidacion l " + 
			"	right join persona p on l.empleado_id != p.id " + 
			"		and year(l.fecha) = :anio " + 
			"		and month(l.fecha) = :mes " + 
			"where p.tipo_empleado_id IS NOT NULL", nativeQuery = true)
	public List<Object[]> findAllLiquidacionPersona(@Param("anio") int anio, @Param("mes") int mes);
	
}
