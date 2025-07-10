package com.projeto.fintech.controller;

import com.projeto.fintech.factory.ContaFactory;
import com.projeto.fintech.model.Conta;
import com.projeto.fintech.repository.ContaRepository;
import com.projeto.fintech.service.LogService;
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

    @Autowired
    private LogService logService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarConta(@RequestBody Conta conta) {
        try {
            // Chamando o método só p/o VSCOde não ficar apitando o erro
            ContaFactory.criarConta(conta.getTipo());
            // Se não der erro, vai ser salvo aqui
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
}