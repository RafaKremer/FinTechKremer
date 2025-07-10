package com.projeto.fintech.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private Long numero;
    private String usuario;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    @JsonBackReference("conta-cartao")
    private Conta conta;
    
    public Cartao(String tipo, Long numero, String usuario) {
        this.tipo = tipo;
        this.numero = numero;
        this.usuario = usuario;
    }
}