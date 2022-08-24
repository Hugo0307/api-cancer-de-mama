package com.api.devweek.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.devweek.entity.FaixaEtaria;
import com.api.devweek.service.FaixaEtariaService;

@RestController
@RequestMapping("/api/faixaetaria")
public class FaixaEtariaController {

    private FaixaEtariaService faixaEtariaService;
    
    public FaixaEtariaController(FaixaEtariaService faixaEtariaService) {
    	this.faixaEtariaService = faixaEtariaService;
    }

    @GetMapping
    public ResponseEntity<List<FaixaEtaria>> findAllFaixaEtaria(){
    	return new ResponseEntity<>(faixaEtariaService.findAllFaixaEtaria(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaixaEtaria> findFaixaEtariaById(@PathVariable Long id) {
    	return new ResponseEntity<>(faixaEtariaService.findFaixaEtariaById(id), HttpStatus.OK);
    }

}
