package com.projeto.fintech.service;

import com.projeto.fintech.model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperacoesContaServiceImpl implements OperacoesContaService {

    @Autowired
    private LogService logService;

    private static final double TAXA_RENDIMENTO_POUPANCA = 0.05; // 5%
    private static final double TAXA_MANUTENCAO_CORRENTE = 2.50; // R$ 2,50

    @Override
    public void calcularRendimento(Conta conta) {
        if ("POUPANCA".equalsIgnoreCase(conta.getTipo())) {
            double rendimento = conta.getSaldo() * TAXA_RENDIMENTO_POUPANCA;
            conta.setSaldo(conta.getSaldo() + rendimento);
            logService.info("Rendimento de R$ " + String.format("%.2f", rendimento) + " aplicado na conta "
                    + conta.getNumero());
        } else {
            logService.info("A conta " + conta.getNumero() + " não é poupança e não possui rendimento.");
        }
    }

    @Override
    public void aplicarTaxaManutencao(Conta conta) {
        if ("CORRENTE".equalsIgnoreCase(conta.getTipo())) {
            conta.setSaldo(conta.getSaldo() - TAXA_MANUTENCAO_CORRENTE);
            logService.info("Taxa de R$ " + String.format("%.2f", TAXA_MANUTENCAO_CORRENTE) + " aplicada na conta "
                    + conta.getNumero());
        } else {
            logService.info("A conta " + conta.getNumero() + " é isenta de taxa de manutenção.");
        }
    }
}