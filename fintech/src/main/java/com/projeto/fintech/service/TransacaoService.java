package com.projeto.fintech.service;

import com.projeto.fintech.model.Conta;
import com.projeto.fintech.model.Transacao;
import com.projeto.fintech.repository.ContaRepository;
import com.projeto.fintech.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TransacaoService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Transactional
    public Transacao processarNovaTransacao(Long contaId, double valor, String tipo) {
        
        Conta conta = contaRepository.findById(contaId)
                .orElseThrow(() -> new RuntimeException("Erro: Conta com ID " + contaId + " não encontrada."));

        if ("DÉBITO".equalsIgnoreCase(tipo)) {
            if (conta.getSaldo() < valor) {
                throw new RuntimeException("Saldo insuficiente para realizar a transação.");
            }
            conta.setSaldo(conta.getSaldo() - valor);
        } else if ("CRÉDITO".equalsIgnoreCase(tipo)) {
            conta.setSaldo(conta.getSaldo() + valor);
        } else {
            throw new RuntimeException("Tipo de transação inválido: " + tipo);
        }

        Transacao novaTransacao = new Transacao();
        novaTransacao.setConta(conta);
        novaTransacao.setValor(valor);
        novaTransacao.setTipo(tipo);
        novaTransacao.setData(LocalDateTime.now());
        
        return transacaoRepository.save(novaTransacao);
    }
}