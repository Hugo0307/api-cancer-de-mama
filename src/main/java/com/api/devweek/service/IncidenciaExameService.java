package com.api.devweek.service;

import com.api.devweek.entity.IncidenciaExame;
import com.api.devweek.exception.ElementNotFoundException;
import com.api.devweek.exception.ListNoContentException;
import com.api.devweek.repository.IncidenciaExamesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenciaExameService {

	private IncidenciaExamesRepository repository;

	public IncidenciaExameService(IncidenciaExamesRepository repository) {
		this.repository = repository;
	}

	public List<IncidenciaExame> findAllIncidencia() {

		var list = repository.findAll();

		if (list.isEmpty()) {
			throw new ListNoContentException();
		}

		return list;
	}

	public IncidenciaExame findIncidenciaById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ElementNotFoundException(id));
	}

}
