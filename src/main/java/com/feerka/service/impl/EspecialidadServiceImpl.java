package com.feerka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feerka.model.Especialidad;
import com.feerka.repo.IEspecialidadRepo;
import com.feerka.repo.IGenericRepo;
import com.feerka.service.IEspecialidadService;



@Service
public class EspecialidadServiceImpl extends CRUDImpl<Especialidad, Integer> implements IEspecialidadService{

	@Autowired
	private IEspecialidadRepo repo;
	
	@Override
	protected IGenericRepo<Especialidad, Integer> getRepo() {
		return repo;
	}
	
	

}
