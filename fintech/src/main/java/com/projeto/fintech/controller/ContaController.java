package com.projeto.fintech.controller;

import com.projeto.fintech.model.Conta;
import com.projeto.fintech.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @PostMapping("/criar")
    public Conta criarConta(@RequestBody Conta conta) {
        return contaRepository.save(conta);
    }

    @GetMapping("/todas")
    public List<Conta> listarTodasContas() {
        return contaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarContaPorId(@PathVariable Long id) {
        Optional<Conta> conta = contaRepository.findById(id);

        return conta.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Conta> atualizarConta(@PathVariable Long id, @RequestBody Conta dadosConta) {
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
    public ResponseEntity<Object> excluirConta(@PathVariable Long id) {
        return contaRepository.findById(id)
                .map(conta -> {
                    contaRepository.delete(conta);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}