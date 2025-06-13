package com.projeto.fintech.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Conta {
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