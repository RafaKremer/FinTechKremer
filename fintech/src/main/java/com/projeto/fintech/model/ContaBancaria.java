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
public class ContaBancaria {
    @Id @GeneratedValue
    protected String titular;
    private String tipo;
    private double saldo;
}