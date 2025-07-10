package com.projeto.fintech.controller;

import com.projeto.fintech.model.Transacao;
import com.projeto.fintech.service.TransacaoService;
import com.projeto.fintech.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;
    @Autowired
    private TransacaoRepository transacaoRepository;

    @PostMapping("/criar")
    public Transacao criarTransacao(@RequestBody Transacao transacaoRequest) {
        return transacaoService.processarNovaTransacao(
                transacaoRequest.getConta().getId(),
                transacaoRequest.getValor(),
                transacaoRequest.getTipo());
    }

    @GetMapping("/todas")
    public List<Transacao> listarTodasTransacoes() {
        return transacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscarTransacaoPorId(@PathVariable("id") Long id) {
        return transacaoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Transacao> atualizarTransacao(@PathVariable("id") Long id,
            @RequestBody Transacao dadosTransacao) {
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
    public ResponseEntity<Object> excluirTransacao(@PathVariable("id") Long id) {
        return transacaoRepository.findById(id)
                .map(transacao -> {
                    transacaoRepository.delete(transacao);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}