package com.example.demo.Repository;

import com.example.demo.Model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Métodos adicionais
    List<Pedido> findByIdCliente(Long idCliente);
    List<Pedido> findByIdsProdutosContaining(Long idProduto);
}
