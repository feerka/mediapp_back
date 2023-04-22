package com.feerka.service;

import com.feerka.dto.ConsultaListaExamenDTO;
import com.feerka.model.Consulta;

public interface IConsultaService extends ICRUD<Consulta, Integer> {	
	
	Consulta registrarTransaccional(ConsultaListaExamenDTO dto);
}
