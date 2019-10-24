package com.ia.tmi.iatmi.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ia.tmi.iatmi.persistence.entities.Liquidacion;

@Repository
public interface LiquidacionRepository extends JpaRepository<Liquidacion, Integer> {

	@Query(value = " select p.id, p.apellido, p.dni, p.email, p.fecha_alta, p.fecha_nacimiento, p.nombre, \r\n" + 
			"p.sexo, p.sueldo_basico_costo_hora, p.habilitacion_id, p.tipo_empleado_id"
			+ " from  persona p where p.id not in (select l.empleado_id from liquidacion l where  year(l.fecha) = :anio and month(l.fecha) = :mes  ) and p.tipo_empleado_id IS NOT NULL", nativeQuery = true)
	public List<Object[]> findAllLiquidacionPersona(@Param("anio") int anio, @Param("mes") int mes);
 
	@Query(value = " select  p.id, p.apellido, p.cbu, p.nombre, l.id as idLiquidacion, l.monto_neto"
			+ " from  persona p, liquidacion l where p.id = l.empleado_id  and year(l.fecha) = :anio and month(l.fecha) = :mes  and l.fecha_pago IS NULL", nativeQuery = true)
	public List<Object[]> findNotPayLiquidacionPersona(@Param("anio") int anio, @Param("mes") int mes);
}
