package com.projeto.fintech.controller;

import com.projeto.fintech.model.Cliente;
import com.projeto.fintech.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/criar")
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping("/todos")
    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        return cliente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente dadosCliente) {
        return clienteRepository.findById(id)
                .map(clienteExistente -> {
                    clienteExistente.setNome(dadosCliente.getNome());
                    clienteExistente.setTipo(dadosCliente.getTipo());

                    Cliente clienteAtualizado = clienteRepository.save(clienteExistente);
                    return ResponseEntity.ok(clienteAtualizado);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Object> excluirCliente(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}