package com.projeto.fintech.factory;

import com.projeto.fintech.model.ContaCorrente;
import com.projeto.fintech.model.ContaPoupanca;
import com.projeto.fintech.model.TipoConta;

public class ContaFactory {

    public static TipoConta criarConta(String tipoDeConta) {
        if ("POUPANCA".equalsIgnoreCase(tipoDeConta)) {
            return new ContaPoupanca();
        } else if ("CORRENTE".equalsIgnoreCase(tipoDeConta)) {
            return new ContaCorrente();
        } else {
            throw new IllegalArgumentException("Tipo de conta desconhecido: " + tipoDeConta);
        }
    }
}