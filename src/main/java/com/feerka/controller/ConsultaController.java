package com.feerka.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.feerka.dto.ConsultaListaExamenDTO;
import com.feerka.exception.ModeloNotFoundException;
import com.feerka.model.Consulta;
import com.feerka.service.IConsultaService;
import com.feerka.dto.ConsultaResumenDTO;
import com.feerka.dto.FiltroConsultaDTO;



@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	@Autowired
	private IConsultaService service;
	
	@GetMapping
	public ResponseEntity<List<Consulta>> listar() throws Exception{
		List<Consulta> lista = service.listar();
		return new ResponseEntity<List<Consulta>>(lista, HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Consulta obj = service.consultarPorId(id);
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		return new ResponseEntity<Consulta>(obj, HttpStatus.OK);
	}
	
	//@ResponseStatus(HttpStatus.NOT_FOUND)
	@GetMapping("/hateoas/{id}")
	public EntityModel<Consulta> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception{
		Consulta obj = service.consultarPorId(id);
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		EntityModel<Consulta> recurso = EntityModel.of(obj);
		
		// localhost:8080/pacientes/4
		WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarPorIdHateoas(id));
		WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).listarPorIdHateoas(id));
		
		recurso.add(link1.withRel("consulta-recurso1"));
		recurso.add(link2.withRel("consulta-recurso2"));
		
		return recurso;
	}
	
	/*@PostMapping
	public ResponseEntity<Consulta> registrar(@Valid @RequestBody Consulta p) throws Exception{
		Consulta obj = service.registrar(p);
		return new ResponseEntity<Consulta>(obj, HttpStatus.CREATED);
	}*/
	
	@PostMapping
	public ResponseEntity<Consulta> registrar(@Valid @RequestBody ConsultaListaExamenDTO p) throws Exception{

		Consulta obj = service.registrarTransaccional(p);

		// localhost:8080/pacientes/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConsulta()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Consulta> modificar(@Valid @RequestBody Consulta p) throws Exception{
		Consulta obj = service.modificar(p);
		return new ResponseEntity<Consulta>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Consulta obj = service.consultarPorId(id);
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/buscar")	
	public ResponseEntity<List<Consulta>> buscarFecha(@RequestParam(value = "fecha")  String fecha) {		
		List<Consulta> consultas = new ArrayList<>();	
		
		consultas = service.buscarFecha(LocalDateTime.parse(fecha));						
		
		return new ResponseEntity<List<Consulta>>(consultas, HttpStatus.OK);
	}
	
	@PostMapping("/buscar/otros")
	public ResponseEntity<List<Consulta>> buscarOtro(@RequestBody FiltroConsultaDTO filtro) {		
		List<Consulta> consultas = new ArrayList<>();
		
		consultas = service.buscar(filtro);			
		
		return new ResponseEntity<List<Consulta>>(consultas, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarResumen")
	public ResponseEntity<List<ConsultaResumenDTO>> listarResumen() {
		List<ConsultaResumenDTO> consultas = new ArrayList<>();
		consultas = service.listarResumen();
		return new ResponseEntity<List<ConsultaResumenDTO>>(consultas, HttpStatus.OK);
	}
	
}
