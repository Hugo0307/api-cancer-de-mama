package com.api.devweek.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.devweek.entity.FaixaEtaria;
import com.api.devweek.repository.FaixaEtariaRepository;

@Service
public class FaixaEtariaService {
	
	private FaixaEtariaRepository repository;

    public FaixaEtariaService(FaixaEtariaRepository repository) {
        this.repository = repository;
    }
    
    public ResponseEntity<?> findAllFaixaEtaria(){
    	return Optional.ofNullable(repository.findAll())
    			.map(faixaEtaria -> ResponseEntity.ok(faixaEtaria))
    			.orElse(ResponseEntity.notFound().build());
    }
    
    public ResponseEntity<?> findFaixaEtariaById(Long id) {
        Optional<FaixaEtaria> faixaEtariaById = repository.findById(id);
        if (faixaEtariaById.isPresent()){
            FaixaEtaria faixaEtariaId = faixaEtariaById.get();
            return new ResponseEntity<>(faixaEtariaId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    public ResponseEntity<?> addFaixaEtaria(FaixaEtaria newFaixaEtaria) {
    	if(newFaixaEtaria.equals(null)) {
    		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    	} else {
    		repository.save(newFaixaEtaria);
    		return new ResponseEntity<>(newFaixaEtaria, HttpStatus.CREATED);
    	}
    }
    
    public ResponseEntity<?> updateFaixaEtaria(FaixaEtaria faixaEtaria, Long id) {
        Optional<FaixaEtaria> currentFaixaEtaria = repository.findById(id);
        if (currentFaixaEtaria.isPresent()) {
            repository.save(faixaEtaria);
            return new ResponseEntity<>(faixaEtaria, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    public ResponseEntity<?> deleteFaixaEtaria(Long id) {
    	if(repository.existsById(id)){
    		repository.deleteById(id);
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	} else {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    }

}
