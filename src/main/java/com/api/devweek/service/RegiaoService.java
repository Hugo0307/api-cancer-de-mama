package com.api.devweek.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.devweek.entity.Regiao;
import com.api.devweek.exception.ElementNotFoundException;
import com.api.devweek.repository.RegiaoRepository;

@Service
public class RegiaoService {
	
	private RegiaoRepository repository;

	public RegiaoService(RegiaoRepository repository) {
		this.repository = repository;
	}
	
	public List<Regiao> findAllRegioes() {
		return repository.findAll();
	}

	public Regiao findRegiaoById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ElementNotFoundException(id));
	}
	
}
