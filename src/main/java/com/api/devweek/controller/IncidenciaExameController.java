package com.api.devweek.controller;

import com.api.devweek.entity.IncidenciaExame;
import com.api.devweek.repository.IncidenciaExamesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/incidencia")
public class IncidenciaExameController {

    private IncidenciaExamesRepository repository;

    public IncidenciaExameController(IncidenciaExamesRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<?> findAllIncidencia(){
        try {
            List<IncidenciaExame> allIncidenciaExames = repository.findAll();
            if (!allIncidenciaExames.isEmpty())
                return new ResponseEntity<>(allIncidenciaExames, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidenciaExame> findById(@PathVariable Long id) {
        Optional<IncidenciaExame> incidenciaExameById = repository.findById(id);
        if (incidenciaExameById.isPresent()){
            IncidenciaExame incidenciaExameId = incidenciaExameById.get();
            return new ResponseEntity<>(incidenciaExameId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/novo")
    public ResponseEntity<IncidenciaExame> addIncidencia(@RequestBody IncidenciaExame incidencia) {
        repository.save(incidencia);
        return new ResponseEntity<>(incidencia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncidenciaExame> updateIncidencia(@RequestBody IncidenciaExame incidencia, @PathVariable Long id) {
        Optional<IncidenciaExame> currentIncidencia = repository.findById(id);
        if (currentIncidencia.isPresent()) {
            repository.save(incidencia);
            return new ResponseEntity<>(incidencia, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/remover/{id}")
    public void deleteIncidencia(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
