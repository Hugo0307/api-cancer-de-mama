package com.api.devweek.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.devweek.entity.Regiao;
import com.api.devweek.service.RegiaoService;

@RestController
@RequestMapping("/api/regioes")
public class RegiaoController {

    private RegiaoService regiaoService;

    public RegiaoController(RegiaoService regiaoService) {
        this.regiaoService = regiaoService;
    }
    
    @GetMapping
    public ResponseEntity<List<Regiao>> findAllRegioes(){
    	return new ResponseEntity<>(regiaoService.findAllRegioes(), HttpStatus.OK); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<Regiao> findRegiaoById(@PathVariable Long id) {
    	return new ResponseEntity<>(regiaoService.findRegiaoById(id), HttpStatus.OK); 
    }

}
