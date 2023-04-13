package com.feerka.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feerka.model.Paciente;
import com.feerka.repo.IGenericRepo;
import com.feerka.repo.IPacienteRepo;
import com.feerka.service.IPacienteService;

@Service
public class PacienteServiceImpl extends CRUDImpl<Paciente, Integer> implements IPacienteService {
	
	@Autowired
	private IPacienteRepo repoPaciente;

	@Override
	protected IGenericRepo<Paciente, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repoPaciente;
	}


}
