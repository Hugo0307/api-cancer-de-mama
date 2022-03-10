package com.api.devweek.controller;

import com.api.devweek.entity.FaixaEtaria;
import com.api.devweek.repository.FaixaEtariaRepository;
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
public class FaixaEtariaController {


    private FaixaEtariaRepository repository;

    public FaixaEtariaController(FaixaEtariaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/faixaetaria")
    public ResponseEntity<?> findAllFaixaEtaria(){
        try {
            List<FaixaEtaria> allFaixasEtarias = repository.findAll();
            if (!allFaixasEtarias.isEmpty())
                return new ResponseEntity<>(allFaixasEtarias, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<FaixaEtaria> findById(@PathVariable Long id) {
        Optional<FaixaEtaria> faixaEtariaById = repository.findById(id);
        if (faixaEtariaById.isPresent()){
            FaixaEtaria faixaEtariaId = faixaEtariaById.get();
            return new ResponseEntity<>(faixaEtariaId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
