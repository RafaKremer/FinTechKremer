package com.projeto.fintech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
class Conta {
    @Id @GeneratedValue
    private Long id;
    private String tipo;
    private Long numero;

    public Conta(String tipo, Long numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    @OneToMany
    private List<Cartao> cartoes;
}