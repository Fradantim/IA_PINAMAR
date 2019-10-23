package com.ia.tmi.iatmi.persistence.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.controllerImpl.StartUpControllerImpl;
import com.ia.tmi.iatmi.persistence.entities.Liquidacion;
import com.ia.tmi.iatmi.persistence.entities.LiquidacionItem;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.persistence.entities.TipoLiquidacion;
import com.ia.tmi.iatmi.persistence.entities.TipoLiquidacionDescuento;
import com.ia.tmi.iatmi.persistence.entities.TipoLiquidacionNoRemunerativa;
import com.ia.tmi.iatmi.persistence.entities.TipoLiquidacionRemunerativa;
import com.ia.tmi.iatmi.persistence.repository.LiquidacionItemRepository;
import com.ia.tmi.iatmi.persistence.repository.LiquidacionRepository;
import com.ia.tmi.iatmi.persistence.repository.TipoLiquidacionRespository;

@Service
public class LiquidacionService {
		
		@Autowired
		private TipoLiquidacionRespository<TipoLiquidacion> tipoLiquidacionRepo;
		
		@Autowired
		private LiquidacionRepository liquidacionRepo;
		
		@Autowired
		private TipoLiquidacionRespository<TipoLiquidacionRemunerativa> tipoRemunerativaRepo;
		
		@Autowired
		private TipoLiquidacionRespository<TipoLiquidacionNoRemunerativa> tipoNoRemunerativaRepo;

		@Autowired
		private TipoLiquidacionRespository<TipoLiquidacionDescuento> tipoDescuentoRepo;

		@Autowired
		private LiquidacionItemRepository liquidacionItemRepo;

		private static final Logger logger = LoggerFactory.getLogger(LiquidacionService.class);

		public List<TipoLiquidacionRemunerativa> findTypeRemunerativaAll(){
			return tipoRemunerativaRepo.findAll();
		}
		
		public List<TipoLiquidacionNoRemunerativa> findTypeNoRemunerativaAll(){
			return tipoNoRemunerativaRepo.findAll();
		}
		
		public List<TipoLiquidacionDescuento> findTypeDescuetnoAll(){
			return tipoDescuentoRepo.findAll();
		}
				
		public TipoLiquidacion save (TipoLiquidacion tipo) {
			return tipoLiquidacionRepo.save(tipo);
		}
		
		public Liquidacion save(Liquidacion liquidacion){
			return liquidacionRepo.save(liquidacion);
		}
				
		public List<LiquidacionItem> findItemsAll(){
			return liquidacionItemRepo.findAll();
		}
		
		public LiquidacionItem save(LiquidacionItem item){
			return liquidacionItemRepo.save(item);
		}
		
		
		public List<Persona> findPersonaByLiquidacionAnioMesAll(int anio,int mes){
			List<Object[]> rows = liquidacionRepo.findAllLiquidacionPersona(anio, mes);
			for (Object[] objects : rows) {
				for (Object object : objects) {
					logger.info("Que tengo en la consulta por atibutos" + object + " toString" + object.toString() + " Valor: " + object.getClass().getName());
				} 
			}
			return null;
		}
		
		
}
