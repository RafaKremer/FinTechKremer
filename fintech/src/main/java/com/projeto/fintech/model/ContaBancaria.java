package com.projeto.fintech.model;

import jakarta.persistence.*;

@Entity
public class ContaBancaria {
    @Id @GeneratedValue
    protected String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }
}