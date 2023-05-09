package com.feerka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.feerka.model.Usuario;
import com.feerka.repo.IUsuarioRepo;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MediappBackendApplicationTests {

	@Autowired
	private IUsuarioRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Test
	void verficarClave() {
		Usuario us = new Usuario();
		us.setIdUsuario(1);
		us.setUsername("feerka@gmail.com");
		us.setPassword(bcrypt.encode("123"));
		us.setEnabled(true);
		
		Usuario retorno = repo.save(us);
		assertTrue(retorno.getPassword().equals(us.getPassword()));
	}

}
