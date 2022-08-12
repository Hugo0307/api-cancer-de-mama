package com.api.devweek.controller;

import java.util.Optional;

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

import com.api.devweek.entity.FaixaEtaria;
import com.api.devweek.repository.FaixaEtariaRepository;
import com.api.devweek.service.FaixaEtariaService;

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
    	return faixaEtariaService.findAllFaixaEtaria();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findFaixaEtariaById(@PathVariable Long id) {
    	return faixaEtariaService.findFaixaEtariaById(id);
    }

    @PostMapping("/novo")
    public ResponseEntity<?> addFaixaEtaria(@RequestBody FaixaEtaria newFaixaEtaria) {
        return faixaEtariaService.addFaixaEtaria(newFaixaEtaria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFaixaEtaria(@RequestBody FaixaEtaria faixaEtaria, @PathVariable Long id) {
        return faixaEtariaService.updateFaixaEtaria(faixaEtaria, id);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<?> deleteFaixaEtaria(@PathVariable Long id) {
        return faixaEtariaService.deleteFaixaEtaria(id);
    }
}
