package com.feerka.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.feerka.model.Paciente;

@Service
public interface IPacienteService extends ICRUD<Paciente, Integer> {
	

	Page<Paciente> listarPageable(Pageable pageable);
}
