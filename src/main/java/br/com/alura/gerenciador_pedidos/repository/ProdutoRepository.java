package br.com.alura.gerenciador_pedidos.repository;

import br.com.alura.gerenciador_pedidos.model.Categoria;
import br.com.alura.gerenciador_pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNome(String nome);
    List<Produto> findByCategoria(Categoria categoria);
    List<Produto> findByPrecoGreaterThan(Double preco);
    List<Produto> findByPrecoLessThan(Double preco);
    List<Produto> findByNomeContainingIgnoreCase(String nome);
    List<Produto> findByCategoriaOrderByPreco(Categoria categoria);
    List<Produto> findByCategoriaOrderByPrecoDesc(Categoria categoria);
    int countByCategoria(Categoria categoria);
    int countByPrecoGreaterThan(Double preco);
    int countByPrecoLessThanOrNomeContainingIgnoreCase(Double preco, String nome);
    List<Produto> findTop3ByOrderByPrecoDesc();
    List<Produto> findTop5ByCategoriaOrderByPreco(Categoria categoria);
}
