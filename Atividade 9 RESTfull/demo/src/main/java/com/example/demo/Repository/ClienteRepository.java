package com.example.demo.Repository;

import com.example.demo.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Método adicional para buscar por nome
    List<Cliente> findByNomeContainingIgnoreCase(String nome);
}