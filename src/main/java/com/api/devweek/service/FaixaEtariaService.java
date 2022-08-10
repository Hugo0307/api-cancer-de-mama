package com.api.devweek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.devweek.entity.FaixaEtaria;
import com.api.devweek.repository.FaixaEtariaRepository;

@Service
public class FaixaEtariaService {
	
	private FaixaEtariaRepository repository;

    public FaixaEtariaService(FaixaEtariaRepository repository) {
        this.repository = repository;
    }
    
    public List<FaixaEtaria> findAllFaixaEtaria(){
    	return Optional.ofNullable(repository.findAll())
    			.map(faixaEtarias -> faixaEtarias)
    			.orElseThrow();
    }

}
