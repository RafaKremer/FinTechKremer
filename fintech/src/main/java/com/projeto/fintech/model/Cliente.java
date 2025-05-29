package com.projeto.fintech.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import jakarta.persistence.*;

@EntityScan
class Cliente {
    @Id @GeneratedValue
    private Long id;
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    private ContaBancaria contaBancaria;

    @OneToMany(cascade = CascadeType.ALL)
    private Cartao cartao;
}