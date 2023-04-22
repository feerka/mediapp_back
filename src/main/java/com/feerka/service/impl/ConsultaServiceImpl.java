package com.feerka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.feerka.dto.ConsultaListaExamenDTO;
import com.feerka.model.Consulta;
import com.feerka.repo.IConsultaExamenRepo;
import com.feerka.repo.IConsultaRepo;
import com.feerka.repo.IGenericRepo;
import com.feerka.service.IConsultaService;

@Service
public class ConsultaServiceImpl extends CRUDImpl<Consulta, Integer> implements IConsultaService{

	@Autowired
	private IConsultaRepo repo;
	
	@Autowired
	private IConsultaExamenRepo ceRepo; 
	
	@Override
	protected IGenericRepo<Consulta, Integer> getRepo() {
		return repo;
	}

	@Transactional
	@Override
	public Consulta registrarTransaccional(ConsultaListaExamenDTO dto) {
		//INSERTAR CONSULTA -> OBTENER PK
		//INSERTER DETALLE CONSULTA <- USANDO LA PK PREVIA
		
		dto.getConsulta().getDetalleConsulta().forEach(det -> det.setConsulta(dto.getConsulta()));
		
		repo.save(dto.getConsulta());
				
		//INSERTO OBJ Y SU LLAVE PRIMARIA ESTA EN 0
		//DESPUES INS OBJ , SU LLAVE PRIMARIA SE ESTABLECE
		
		dto.getLstExamen().forEach(ex -> ceRepo.registrar(dto.getConsulta().getIdConsulta(), ex.getIdExamen()));
		
		return dto.getConsulta();
		
		/*List<DetalleConsulta> listaDetalle = consulta.getDetalleConsulta();
		for(DetalleConsulta det : listaDetalle) {
			det.setConsulta(consulta);
		}*/
		
	}
	
	

}
