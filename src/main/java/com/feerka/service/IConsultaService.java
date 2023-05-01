package com.feerka.service;

import java.time.LocalDateTime;
import java.util.List;

import com.feerka.dto.ConsultaListaExamenDTO;
import com.feerka.model.Consulta;
import com.feerka.dto.ConsultaResumenDTO;
import com.feerka.dto.FiltroConsultaDTO;

public interface IConsultaService extends ICRUD<Consulta, Integer> {	
	
	Consulta registrarTransaccional(ConsultaListaExamenDTO dto);
	
	List<Consulta> buscar(FiltroConsultaDTO filtro);

	List<Consulta> buscarFecha(LocalDateTime fecha);
	
	List<ConsultaResumenDTO> listarResumen();
	
	byte[] generarReporte();
}
