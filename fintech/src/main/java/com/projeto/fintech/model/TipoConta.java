package com.projeto.fintech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TipoConta {
    @Id @GeneratedValue
    private Long id;
    protected double saldo;

    public abstract void calcularRendimento();
}