package com.example.demo.Controller;

import com.example.demo.Model.Cliente;
import com.example.demo.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Cliente listarPorId(@PathVariable Long id) {
        return clienteService.listarPorId(id);
    }

    @GetMapping("/buscar")
    public List<Cliente> listarPorNome(@RequestParam String nome) {
        return clienteService.listarPorNome(nome);
    }
}