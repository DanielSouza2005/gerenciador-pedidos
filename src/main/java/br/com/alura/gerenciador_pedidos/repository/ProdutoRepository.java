package br.com.alura.gerenciador_pedidos.repository;

import br.com.alura.gerenciador_pedidos.model.Categoria;
import br.com.alura.gerenciador_pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query("SELECT p FROM Produto p WHERE p.preco > :preco")
    List<Produto> buscaPorPrecoMaiorQue(Double preco);

    @Query("SELECT p FROM Produto p ORDER BY p.preco ASC")
    List<Produto> buscaPorOrderByPreco();

    @Query("SELECT p FROM Produto p ORDER BY p.preco DESC")
    List<Produto> buscaPorOrderByPrecoDesc();

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE :letra%")
    List<Produto> buscaPorProdutosQueComecamCom(@Param("letra") String letra);

    @Query("SELECT AVG(p.preco) FROM Produto p")
    double buscaMediaPrecoProdutos();

    @Query("SELECT MAX(p.preco) FROM Produto p WHERE p.categoria = :categoria")
    double buscaPrecoMaximoPorCategoria(Categoria categoria);

    @Query("""
            SELECT c
            FROM Categoria c
            JOIN c.produtos p
            GROUP BY c
            HAVING COUNT(p) > 10
            """)
    List<Categoria> buscarCategoriasComMaisDeDezProdutos();

    @Query("""
            SELECT p
                   FROM Produto p
                   WHERE p.nome LIKE %:nome%
                      OR p.categoria = :categoria
            """)
    List<Produto> buscarProdutosPorNomeOuCategoria(String nome, Categoria categoria);

    @Query(value = """
            SELECT *
            FROM produto
            ORDER BY valor DESC
            LIMIT 5
            """,
            nativeQuery = true
    )
    List<Produto> buscarTresProdutosMaisCaros();

}
