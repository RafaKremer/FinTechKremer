package com.projeto.fintech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cartao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // gerar ID automaticamente
    private Long id;
    private String tipo;
    private int numero;
    private String usuario;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;
    
    public Cartao(String tipo, int numero, String usuario) {
        this.tipo = tipo;
        this.numero = numero;
        this.usuario = usuario;
    }

}