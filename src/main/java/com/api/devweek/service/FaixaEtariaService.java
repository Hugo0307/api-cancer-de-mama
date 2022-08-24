package com.api.devweek.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.devweek.entity.FaixaEtaria;
import com.api.devweek.exception.ElementNotFoundException;
import com.api.devweek.repository.FaixaEtariaRepository;

@Service
public class FaixaEtariaService {
	
	private FaixaEtariaRepository repository;

    public FaixaEtariaService(FaixaEtariaRepository repository) {
        this.repository = repository;
    }
    
    public List<FaixaEtaria> findAllFaixaEtaria(){
    	return repository.findAll();
    }
    
    public FaixaEtaria findFaixaEtariaById(Long id) {
    	return repository.findById(id).orElseThrow(() -> new ElementNotFoundException(id));
    }
    
}
