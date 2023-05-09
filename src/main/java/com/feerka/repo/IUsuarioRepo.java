package com.feerka.repo;

import com.feerka.model.Usuario;

public interface IUsuarioRepo extends IGenericRepo<Usuario, Integer>  {

	//from usuario where username = ?
	Usuario findOneByUsername(String username);	
}
