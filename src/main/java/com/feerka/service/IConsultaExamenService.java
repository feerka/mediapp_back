package com.feerka.service;

import java.util.List;
import com.feerka.model.ConsultaExamen;
public interface IConsultaExamenService {

	List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta);

}
