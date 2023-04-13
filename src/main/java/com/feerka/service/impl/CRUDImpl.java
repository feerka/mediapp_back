package com.feerka.service.impl;

import java.util.List;
import java.util.Optional;


import com.feerka.repo.IGenericRepo;
import com.feerka.service.ICRUD;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID>{


	protected abstract IGenericRepo<T, ID> getRepo();
	
	@Override
	public T registrar(T t) throws Exception{
		return getRepo().save(t);
	}

	@Override
	public T modificar(T t) throws Exception{
		return getRepo().save(t);
	}

	@Override
	public List<T> listar() throws Exception{
		return getRepo().findAll();
	}

	@Override
	public T consultarPorId(ID id) throws Exception{
		return getRepo().findById(id).orElse(null);
		//Optional<T> res = getRepo().findById(id);
		//return res.isPresent() ? res.get() : null;
	}

	@Override
	public void eliminar(ID id) throws Exception{
		getRepo().deleteById(id);
	}

}
