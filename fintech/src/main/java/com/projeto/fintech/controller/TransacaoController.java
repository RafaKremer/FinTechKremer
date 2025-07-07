package com.projeto.fintech.controller;

import com.projeto.fintech.model.Transacao;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final List<Transacao> bancoDeTransacoes = new ArrayList<>();
    private static long proximoId = 1;


    @PostMapping("/criar")
    public Transacao criarTransacao(@RequestBody Transacao transacao) {
        transacao.setId(proximoId++);
        transacao.setData(LocalDateTime.now());
        bancoDeTransacoes.add(transacao);
        return transacao;
    }

    @GetMapping("/conta/{contaId}")
    public List<Transacao> listarTransacoesPorConta(@PathVariable Long contaId) {
        return bancoDeTransacoes.stream()
                .filter(t -> t.getConta() != null && t.getConta().getId().equals(contaId))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Transacao buscarTransacaoPorId(@PathVariable Long id) {
        return bancoDeTransacoes.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}