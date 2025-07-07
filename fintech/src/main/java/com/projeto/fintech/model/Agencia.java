package com.projeto.fintech.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;

    @OneToMany
    @JoinColumn(name = "agencia_id")
    private List<Cliente> clientes;

    public Agencia(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }
}