package com.projeto.fintech.controller;

import com.projeto.fintech.model.Transacao;
import com.projeto.fintech.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @PostMapping("/criar")
    public Transacao criarTransacao(@RequestBody Transacao transacao) {
        transacao.setData(LocalDateTime.now());
        return transacaoRepository.save(transacao);
    }

    @GetMapping("/todas")
    public List<Transacao> listarTodasTransacoes() {
        return transacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscarTransacaoPorId(@PathVariable Long id) {
        return transacaoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Transacao> atualizarTransacao(@PathVariable Long id, @RequestBody Transacao dadosTransacao) {
        return transacaoRepository.findById(id)
                .map(transacaoExistente -> {
                    transacaoExistente.setValor(dadosTransacao.getValor());
                    transacaoExistente.setTipo(dadosTransacao.getTipo());
                    Transacao transacaoAtualizada = transacaoRepository.save(transacaoExistente);
                    return ResponseEntity.ok(transacaoAtualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Object> excluirTransacao(@PathVariable Long id) {
        return transacaoRepository.findById(id)
                .map(transacao -> {
                    transacaoRepository.delete(transacao);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}