package com.api.devweek.controller;

import com.api.devweek.entity.IncidenciaExame;
import com.api.devweek.repository.IncidenciaExamesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class IncidenciaExameController {

    private IncidenciaExamesRepository repository;

    public IncidenciaExameController(IncidenciaExamesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/incidencia")
    public ResponseEntity<?> findAllIncidenciaExame(){
        try {
            List<IncidenciaExame> allIncidenciaExames = repository.findAll();
            if (!allIncidenciaExames.isEmpty())
                return new ResponseEntity<>(allIncidenciaExames, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/incidencia/{id}")
    public ResponseEntity<IncidenciaExame> findById(@PathVariable Long id) {
        Optional<IncidenciaExame> incidenciaExameById = repository.findById(id);
        if (incidenciaExameById.isPresent()){
            IncidenciaExame incidenciaExameId = incidenciaExameById.get();
            return new ResponseEntity<>(incidenciaExameId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
