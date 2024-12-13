package com.example.demo.Service;

import com.example.demo.Model.Cliente;
import com.example.demo.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        if (cliente.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente listarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
    }

    public List<Cliente> listarPorNome(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }
}