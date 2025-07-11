package com.projeto.fintech.service;

import com.projeto.fintech.model.Conta;

public interface OperacoesContaService {

    /**
     * Calcula o rendimento de uma conta e atualiza seu saldo.
     * @param conta O objeto Conta sobre o qual o rendimento será calculado.
     */
    void calcularRendimento(Conta conta);

    /**
     * Aplica uma taxa de manutenção em uma conta e atualiza seu saldo.
     * @param conta O objeto Conta que sofrerá o débito da taxa.
     */
    void aplicarTaxaManutencao(Conta conta);
}