package com.api.devweek.controller;

import com.api.devweek.entity.Regiao;
import com.api.devweek.repository.RegiaoRepository;
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
public class RegiaoController {

    private RegiaoRepository repository;

    public RegiaoController(RegiaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/regioes")
    public ResponseEntity<?> findAllRegioes(){
        try {
            List<Regiao> allRegioes = repository.findAll();
            if (!allRegioes.isEmpty())
            return new ResponseEntity<>(allRegioes, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/regiao/{id}")
    public ResponseEntity<Regiao> findById(@PathVariable Long id) {
        Optional<Regiao> regiaoById = repository.findById(id);
        if (regiaoById.isPresent()){
            Regiao regiaoId = regiaoById.get();
            return new ResponseEntity<>(regiaoId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
