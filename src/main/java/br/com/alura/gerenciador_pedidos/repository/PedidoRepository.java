package br.com.alura.gerenciador_pedidos.repository;

import br.com.alura.gerenciador_pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByDataNull();
    List<Pedido> findByDataNotNull();
    List<Pedido> findByDataGreaterThan(LocalDate data);
    List<Pedido> findByDataLessThan(LocalDate data);
    List<Pedido> findByDataBetween(LocalDate data1, LocalDate data2);
}
