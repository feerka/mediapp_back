package com.feerka.service;

import java.util.List;


public interface ICRUD <T, ID> {

	T registrar(T t) throws Exception;
	T modificar(T t)throws Exception;
	List<T> listar()throws Exception;
	T consultarPorId(ID id)throws Exception;
	void eliminar(ID id)throws Exception;
}
