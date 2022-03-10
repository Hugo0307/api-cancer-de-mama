package com.api.devweek.controller;

import com.api.devweek.entity.Regiao;
import com.api.devweek.repository.RegiaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/regiao")
public class RegiaoController {

    private RegiaoRepository repository;

    public RegiaoController(RegiaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
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

    @GetMapping("/{id}")
    public ResponseEntity<Regiao> findById(@PathVariable Long id) {
        Optional<Regiao> regiaoById = repository.findById(id);
        if (regiaoById.isPresent()){
            Regiao regiaoId = (Regiao) regiaoById.get();
            return new ResponseEntity<>(regiaoId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/novo")
    public Regiao addRegiao(@RequestBody Regiao newRegiao) {
        return repository.save(newRegiao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Regiao> updateRegiao(@RequestBody Regiao regiao, @PathVariable Long id) {
        Optional<Regiao> currentRegiao = repository.findById(id);
        if (currentRegiao.isPresent()) {
            repository.save(regiao);
            return new ResponseEntity<>(regiao, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/remover/{id}")
    public void deleteRegiao(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
