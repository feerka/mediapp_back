package com.feerka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feerka.model.Medico;
import com.feerka.repo.IGenericRepo;
import com.feerka.repo.IMedicoRepo;
import com.feerka.service.IMedicoService;

@Service
public class MedicoServiceImpl extends CRUDImpl<Medico, Integer> implements IMedicoService {

	@Autowired
	private IMedicoRepo repoMedico;

	@Override
	protected IGenericRepo<Medico, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repoMedico;
	}

}
