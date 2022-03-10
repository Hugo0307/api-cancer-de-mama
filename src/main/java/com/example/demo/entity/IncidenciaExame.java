package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class IncidenciaExame {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private Long id;

    private Integer regiaoId;
    private Integer mes;
    private Long faixaId;
    private Integer qtdExames;

    public IncidenciaExame(Integer regiaoId, Integer mes, Long faixaId, Integer qtdExames) {
        this.regiaoId = regiaoId;
        this.mes = mes;
        this.faixaId = faixaId;
        this.qtdExames = qtdExames;
    }

    public IncidenciaExame() { }

    public Long getId() {
        return id;
    }

    public Integer getRegiaoId() {
        return regiaoId;
    }

    public void setRegiaoId(Integer regiaoId) {
        this.regiaoId = regiaoId;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Long getFaixaId() {
        return faixaId;
    }

    public void setFaixaId(Long faixaId) {
        this.faixaId = faixaId;
    }

    public Integer getQtdExames() {
        return qtdExames;
    }

    public void setQtdExames(Integer qtdExames) {
        this.qtdExames = qtdExames;
    }
}
