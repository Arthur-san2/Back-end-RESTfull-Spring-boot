package com.example.demo.Service;

import com.example.demo.Model.Produto;
import com.example.demo.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Salvar um produto
    public Produto salvar(Produto produto) {
        if (produto.getNome() == null || produto.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }
        if (produto.getPreco() < 0) {
            throw new IllegalArgumentException("O preço do produto não pode ser negativo.");
        }
        return produtoRepository.save(produto);
    }

    // Listar todos os produtos
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // Buscar um produto pelo ID
    public Produto buscarPorId(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty()) {
            throw new IllegalArgumentException("Produto não encontrado para o ID fornecido.");
        }
        return produto.get();
    }

    // Buscar produtos pelo nome
    public List<Produto> buscarPorNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome para busca não pode ser vazio.");
        }
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }
}