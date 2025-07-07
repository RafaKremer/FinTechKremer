package com.projeto.fintech.factory;

import com.projeto.fintech.model.ContaCorrente;
import com.projeto.fintech.model.ContaPoupanca;
import com.projeto.fintech.model.TipoConta;

// A nossa "Fábrica" de Contas
public class ContaFactory {

    // O método estático que cria o objeto desejado
    public static TipoConta criarConta(String tipoDeConta) {
        if ("POUPANCA".equalsIgnoreCase(tipoDeConta)) {
            return new ContaPoupanca();
        } else if ("CORRENTE".equalsIgnoreCase(tipoDeConta)) {
            return new ContaCorrente();
        } else {
            // Lança uma exceção se o tipo for desconhecido
            throw new IllegalArgumentException("Tipo de conta desconhecido: " + tipoDeConta);
        }
    }
}