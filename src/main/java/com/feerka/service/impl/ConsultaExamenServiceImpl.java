package com.feerka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feerka.model.ConsultaExamen;
import com.feerka.repo.IConsultaExamenRepo;
import com.feerka.service.IConsultaExamenService;

@Service
public class ConsultaExamenServiceImpl implements IConsultaExamenService{

	@Autowired
	private IConsultaExamenRepo repo;
	
	@Override
	public List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta) {
		return repo.listarExamenesPorConsulta(idconsulta);
	}
}
