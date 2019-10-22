package com.ia.tmi.iatmi.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.Clase;
import com.ia.tmi.iatmi.persistence.entities.Liquidacion;
import com.ia.tmi.iatmi.persistence.entities.TipoLiquidacionDescuento;
import com.ia.tmi.iatmi.persistence.entities.TipoLiquidacionNoRemunerativa;
import com.ia.tmi.iatmi.persistence.entities.TipoLiquidacionRemunerativa;
import com.ia.tmi.iatmi.persistence.repository.ClaseRepository;
import com.ia.tmi.iatmi.persistence.repository.LiquidacionRepository;
import com.ia.tmi.iatmi.persistence.repository.TipoEmpleadoRepository;
import com.ia.tmi.iatmi.persistence.repository.TipoLiquidacionRespository;

@Service
public class LiquidacionService {
		
		@Autowired
		private LiquidacionRepository liquidacionRepo;
		
		@Autowired
		private TipoLiquidacionRespository<TipoLiquidacionRemunerativa> tipoRemunerativaRepo;
		
		@Autowired
		private TipoLiquidacionRespository<TipoLiquidacionNoRemunerativa> tipoNoRemunerativaRepo;

		@Autowired
		private TipoLiquidacionRespository<TipoLiquidacionDescuento> tipoDescuentoRepo;

		public List<TipoLiquidacionRemunerativa> findTypeRemunerativaAll(){
			return tipoRemunerativaRepo.findAll();
		}
		
		public List<TipoLiquidacionNoRemunerativa> findTypeNoRemunerativaAll(){
			return tipoNoRemunerativaRepo.findAll();
		}
		
		public List<TipoLiquidacionDescuento> findTypeDescuetnoAll(){
			return tipoDescuentoRepo.findAll();
		}
				
		public Liquidacion save(Liquidacion liquidacion){
			return liquidacionRepo.save(liquidacion);
		}
}
