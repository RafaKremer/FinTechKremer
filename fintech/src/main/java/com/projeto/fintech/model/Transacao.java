package com.projeto.fintech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valor;
    private LocalDateTime data;
    private String tipo; // Ex: "crédito" ou "débito"

    @ManyToOne // Muitas transações podem estar associadas a uma conta
    @JoinColumn(name = "conta_id")
    private Conta conta;

    public Transacao(double valor, String tipo, Conta conta) {
        this.valor = valor;
        this.tipo = tipo;
        this.conta = conta;
        this.data = LocalDateTime.now();
    }
}