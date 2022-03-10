package com.api.devweek.entity;

import javax.persistence.*;

@Entity
public class Regiao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String regiao;
    private Long total_exames;

    public Regiao(String regiao, Long total_exames) {
        this.regiao = regiao;
        this.total_exames = total_exames;
    }

    public Regiao() { }

    public Long getId() {
        return id;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Long getTotal_exames() {
        return total_exames;
    }

    public void setTotal_exames(Long total_exames) {
        this.total_exames = total_exames;
    }
}
