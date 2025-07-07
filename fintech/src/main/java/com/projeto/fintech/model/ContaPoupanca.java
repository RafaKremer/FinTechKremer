package com.projeto.fintech.model;

import jakarta.persistence.Entity;

@Entity
public class ContaPoupanca extends TipoConta {

    private static final double TAXA_RENDIMENTO = 0.05; // 5%

    @Override
    public void calcularRendimento() {
        double rendimento = this.saldo * TAXA_RENDIMENTO;
        this.saldo += rendimento;
        System.out.println("Rendimento da conta poupança de R$ " + rendimento + " calculado. Saldo atual: R$ " + this.saldo);
    }
}