package com.feerka.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feerka.exception.ModeloNotFoundException;
import com.feerka.model.Paciente;
import com.feerka.service.IPacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private IPacienteService servicePac;
	
	@GetMapping
	public ResponseEntity<List<Paciente>> listar ()throws Exception{
		List<Paciente> lista = servicePac.listar();
		return new ResponseEntity<List<Paciente>>(lista, HttpStatus.I_AM_A_TEAPOT);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> listarPorPaciente (@PathVariable("id") Integer id)throws Exception{
		Paciente pac = servicePac.consultarPorId(id);
		
		if(pac == null) {
			throw new ModeloNotFoundException("Paciente no encontrado " +id);
		}
		return new ResponseEntity<Paciente>(pac, HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public ResponseEntity<Paciente> registrar (@Valid @RequestBody Paciente pac)throws Exception{
		Paciente paciente = servicePac.registrar(pac);
		return new ResponseEntity<Paciente>(paciente, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Paciente> modificar (@RequestBody Paciente pac)throws Exception{
		Paciente paciente = servicePac.modificar(pac);
		return new ResponseEntity<Paciente>(paciente, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar (@PathVariable("id") Integer id)throws Exception{
		
	    Paciente pac = servicePac.consultarPorId(id);
		
		if(pac == null) {
			throw new ModeloNotFoundException("Paciente no encontrado " +id);
		}
		servicePac.eliminar(id);
		
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	

}
