package com.api.devweek.controller;

import com.api.devweek.entity.FaixaEtaria;
import com.api.devweek.repository.FaixaEtariaRepository;
import com.api.devweek.service.FaixaEtariaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/faixaetaria")
public class FaixaEtariaController {

	private FaixaEtariaRepository repository;
	
    private FaixaEtariaService faixaEtariaService;
    
    public FaixaEtariaController(FaixaEtariaService faixaEtariaService) {
    	this.faixaEtariaService = faixaEtariaService;
    }

    @GetMapping
    public ResponseEntity<?> findAllFaixaEtaria(){
    	return ResponseEntity.ok(faixaEtariaService.findAllFaixaEtaria());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaixaEtaria> findById(@PathVariable Long id) {
        Optional<FaixaEtaria> faixaEtariaById = repository.findById(id);
        if (faixaEtariaById.isPresent()){
            FaixaEtaria faixaEtariaId = faixaEtariaById.get();
            return new ResponseEntity<>(faixaEtariaId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/novo")
    public ResponseEntity<FaixaEtaria> addFaixaEtaria(@RequestBody FaixaEtaria newFaixaEtaria) {
        repository.save(newFaixaEtaria);
        return new ResponseEntity<>(newFaixaEtaria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FaixaEtaria> updateFaixaEtaria(@RequestBody FaixaEtaria faixaEtaria, @PathVariable Long id) {
        Optional<FaixaEtaria> currentFaixaEtaria = repository.findById(id);
        if (currentFaixaEtaria.isPresent()) {
            repository.save(faixaEtaria);
            return new ResponseEntity<>(faixaEtaria, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/remover/{id}")
    public void deleteFaixaEtaria(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
