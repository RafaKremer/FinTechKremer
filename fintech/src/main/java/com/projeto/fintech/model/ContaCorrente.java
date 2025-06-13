package com.projeto.fintech.model;

import jakarta.persistence.Entity;

@Entity
class ContaCorrente extends TipoConta {
    @Override
    public void calcularRendimento() {
        System.out.println("Conta corrente não possui rendimento");
    }
}
