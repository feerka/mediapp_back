package com.feerka.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.feerka.dto.ConsultaListaExamenDTO;
import com.feerka.model.Consulta;
import com.feerka.repo.IConsultaExamenRepo;
import com.feerka.repo.IConsultaRepo;
import com.feerka.repo.IGenericRepo;
import com.feerka.service.IConsultaService;
import com.feerka.dto.ConsultaResumenDTO;
import com.feerka.dto.FiltroConsultaDTO;

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
	@Override
	public List<Consulta> buscar(FiltroConsultaDTO filtro) {
		return repo.buscar(filtro.getDni(), filtro.getNombreCompleto());
	}

	@Override
	public List<Consulta> buscarFecha(LocalDateTime fecha) {
		return repo.buscarFecha(fecha, fecha.plusDays(1));
	}
	
	@Override
	public List<ConsultaResumenDTO> listarResumen() {
		//List<Object[]>
		//cantidad	fecha
		//[1	,		"15/05/2021"]
		//[2	,		"22/05/2021"]
		//[5	,		"24/04/2021"]
		List<ConsultaResumenDTO> consultas = new ArrayList<>();
		repo.listarResumen().forEach(x -> {
			ConsultaResumenDTO cr = new ConsultaResumenDTO();
			cr.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			cr.setFecha(String.valueOf(x[1]));
			consultas.add(cr);
		});
		return consultas;
	}
	
	

}
