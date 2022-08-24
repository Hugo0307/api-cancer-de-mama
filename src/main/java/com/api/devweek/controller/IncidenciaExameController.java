package com.api.devweek.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.devweek.entity.IncidenciaExame;
import com.api.devweek.service.IncidenciaExameService;

@RestController
@RequestMapping("/api/incidencia")
public class IncidenciaExameController {

    private IncidenciaExameService incidenciaExameService;

    public IncidenciaExameController(IncidenciaExameService incidenciaExameService) {
        this.incidenciaExameService = incidenciaExameService;
    }

    @GetMapping
    public ResponseEntity<List<IncidenciaExame>> findAllIncidencia(){
    	return new ResponseEntity<>(incidenciaExameService.findAllIncidencia(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidenciaExame> findIncidenciaById(@PathVariable Long id) {
    	return new ResponseEntity<>(incidenciaExameService.findIncidenciaById(id), HttpStatus.OK);
    }

}
