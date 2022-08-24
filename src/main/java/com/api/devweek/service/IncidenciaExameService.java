package com.api.devweek.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.devweek.entity.IncidenciaExame;
import com.api.devweek.exception.ElementNotFoundException;
import com.api.devweek.repository.IncidenciaExamesRepository;

@Service
public class IncidenciaExameService {

	private IncidenciaExamesRepository repository;

	public IncidenciaExameService(IncidenciaExamesRepository repository) {
		this.repository = repository;
	}

	public List<IncidenciaExame> findAllIncidencia() {
		return repository.findAll();
	}

	public IncidenciaExame findIncidenciaById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ElementNotFoundException(id));
	}

}
