package com.example.demo.Service;

import com.example.demo.Model.Pedido;
import com.example.demo.Repository.PedidoRepository;
import com.example.demo.Repository.ClienteRepository;
import com.example.demo.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    // Salvar um pedido
    public Pedido salvar(Pedido pedido) {
        // Validação do cliente
        if (pedido.getIdCliente() == null || clienteRepository.findById(pedido.getIdCliente())!optional.isPresent()) {
            throw new IllegalArgumentException("Cliente inválido ou não encontrado.");
        }

        // Validação dos produtos
        if (pedido.getIdsProdutos() == null || pedido.getIdsProdutos().isEmpty()) {
            throw new IllegalArgumentException("O pedido deve conter pelo menos um produto.");
        }

        for (Long idProduto : pedido.getIdsProdutos()) {
            if (produtoRepository.findById(idProduto).isEmpty()) {
                throw new IllegalArgumentException("Produto inválido ou não encontrado para o ID: " + idProduto);
            }
        }

        return pedidoRepository.save(pedido);
    }

    // Listar todos os pedidos
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    // Buscar pedido por ID
    public Pedido buscarPorId(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isEmpty()) {
            throw new IllegalArgumentException("Pedido não encontrado para o ID fornecido.");
        }
        return pedido.get();
    }

    // Buscar pedidos por ID do cliente
    public List<Pedido> buscarPorIdCliente(Long idCliente) {
        if (idCliente == null || clienteRepository.findById(idCliente).isEmpty()) {
            throw new IllegalArgumentException("Cliente inválido ou não encontrado.");
        }
        return pedidoRepository.findByIdCliente(idCliente);
    }

    // Buscar pedidos por ID de um produto
    public List<Pedido> buscarPorIdProduto(Long idProduto) {
        if (idProduto == null || produtoRepository.findById(idProduto).isEmpty()) {
            throw new IllegalArgumentException("Produto inválido ou não encontrado.");
        }
        return pedidoRepository.findByIdsProdutosContaining(idProduto);
    }
}
