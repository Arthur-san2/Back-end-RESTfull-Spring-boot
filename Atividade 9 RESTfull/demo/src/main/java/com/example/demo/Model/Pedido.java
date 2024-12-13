package com.example.demo.Model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idCliente;

    @ElementCollection
    private List<Long> idsProdutos;

    // Construtor padrão
    public Pedido() {}

    // Construtor com argumentos
    public Pedido(Long id, Long idCliente, List<Long> idsProdutos) {
        this.id = id;
        this.idCliente = idCliente;
        this.idsProdutos = idsProdutos;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public List<Long> getIdsProdutos() {
        return idsProdutos;
    }

    public void setIdsProdutos(List<Long> idsProdutos) {
        this.idsProdutos = idsProdutos;
    }
}