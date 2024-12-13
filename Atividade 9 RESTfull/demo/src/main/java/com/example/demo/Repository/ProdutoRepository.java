package com.example.demo.Repository;

import com.example.demo.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Método adicional para buscar por nome
    List<Produto> findByNomeContainingIgnoreCase(String nome);
}