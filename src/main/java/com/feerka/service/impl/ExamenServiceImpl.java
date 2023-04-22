package com.feerka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feerka.model.Examen;
import com.feerka.repo.IExamenRepo;
import com.feerka.repo.IGenericRepo;
import com.feerka.service.IExamenService;



@Service
public class ExamenServiceImpl extends CRUDImpl<Examen, Integer> implements IExamenService{

	@Autowired
	private IExamenRepo repo;
	
	@Override
	protected IGenericRepo<Examen, Integer> getRepo() {
		return repo;
	}
	
	

}
