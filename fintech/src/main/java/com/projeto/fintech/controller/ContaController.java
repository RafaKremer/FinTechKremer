package com.projeto.fintech.controller;

import com.projeto.fintech.factory.ContaFactory;
import com.projeto.fintech.model.Conta;
import com.projeto.fintech.repository.ContaRepository;
import com.projeto.fintech.service.LogService;
import com.projeto.fintech.service.OperacoesContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;
    
    @Autowired
    private LogService logService;

    @Autowired
    private ContaFactory contaFactory;
    
    @Autowired
    private OperacoesContaService operacoesContaService;
    @PostMapping("/criar")
    public ResponseEntity<?> criarConta(@RequestBody Conta conta) {
        try {
            contaFactory.criarConta(conta.getTipo());
            Conta novaConta = contaRepository.save(conta);
            return ResponseEntity.status(201).body(novaConta);
        } catch (IllegalArgumentException e) {
            logService.error("Tentativa de criar conta com tipo inválido: " + conta.getTipo());
            return ResponseEntity.badRequest().body("Erro ao criar conta: " + e.getMessage());
        }
    }

    @GetMapping("/todas")
    public List<Conta> listarTodasContas() {
        return contaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarContaPorId(@PathVariable("id") Long id) {
        Optional<Conta> conta = contaRepository.findById(id);

        return conta.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Conta> atualizarConta(@PathVariable("id") Long id, @RequestBody Conta dadosConta) {
        return contaRepository.findById(id)
                .map(contaExistente -> {
                    contaExistente.setNumero(dadosConta.getNumero());
                    contaExistente.setTipo(dadosConta.getTipo());
                    contaExistente.setSaldo(dadosConta.getSaldo());

                    Conta contaAtualizada = contaRepository.save(contaExistente);
                    return ResponseEntity.ok(contaAtualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Object> excluirConta(@PathVariable("id") Long id) {
        return contaRepository.findById(id)
                .map(conta -> {
                    contaRepository.delete(conta);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/calcular-rendimento")
    @Transactional
    public ResponseEntity<Conta> acionarCalculoRendimento(@PathVariable Long id) {
        return contaRepository.findById(id)
                .map(conta -> {
                    operacoesContaService.calcularRendimento(conta);
                    return ResponseEntity.ok(conta);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/aplicar-taxa")
    @Transactional
    public ResponseEntity<Conta> acionarAplicacaoTaxa(@PathVariable Long id) {
        return contaRepository.findById(id)
                .map(conta -> {
                    operacoesContaService.aplicarTaxaManutencao(conta);
                    return ResponseEntity.ok(conta);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}