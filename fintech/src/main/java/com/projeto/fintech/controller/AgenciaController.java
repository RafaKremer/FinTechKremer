package com.projeto.fintech.controller;

import com.projeto.fintech.model.Agencia;
import com.projeto.fintech.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agencias")
public class AgenciaController {

    @Autowired
    private AgenciaRepository agenciaRepository;

    @PostMapping("/criar")
    public Agencia criarAgencia(@RequestBody Agencia agencia) {
        return agenciaRepository.save(agencia);
    }

    @GetMapping("/todas")
    public List<Agencia> listarTodasAgencias() {
        return agenciaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agencia> buscarAgenciaPorId(@PathVariable Long id) {
        Optional<Agencia> agencia = agenciaRepository.findById(id);

        return agencia.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Agencia> atualizarAgencia(@PathVariable Long id, @RequestBody Agencia dadosAgencia) {
        return agenciaRepository.findById(id)
                .map(agenciaExistente -> {
                    agenciaExistente.setNome(dadosAgencia.getNome());
                    agenciaExistente.setEndereco(dadosAgencia.getEndereco());
                    
                    Agencia agenciaAtualizada = agenciaRepository.save(agenciaExistente);
                    return ResponseEntity.ok(agenciaAtualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Object> excluirAgencia(@PathVariable Long id) {
        return agenciaRepository.findById(id)
                .map(agencia -> {
                    agenciaRepository.delete(agencia);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}