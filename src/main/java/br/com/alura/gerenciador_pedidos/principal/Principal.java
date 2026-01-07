package br.com.alura.gerenciador_pedidos.principal;

import br.com.alura.gerenciador_pedidos.model.*;
import br.com.alura.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.alura.gerenciador_pedidos.repository.FornecedorRepository;
import br.com.alura.gerenciador_pedidos.repository.PedidoRepository;
import br.com.alura.gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class Principal {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public void cadastrarEntidades() {
        Categoria categoria = new Categoria("Teste 4");
        categoriaRepository.save(categoria);

        Produto produto = new Produto("Maçã", 10.0, categoria);
        produtoRepository.save(produto);

        Pedido pedido = new Pedido(LocalDate.now());
        pedidoRepository.save(pedido);

        Fornecedor fornecedor = new Fornecedor("Fernando");
        fornecedorRepository.save(fornecedor);

        FornecedorProduto fp = new FornecedorProduto(produto, fornecedor);
        fornecedor.getProdutos().add(fp);
        produto.getFornecedores().add(fp);

        fornecedorRepository.save(fornecedor);
    }

    public void testarQueriesRepositories() {

        Categoria categoria = categoriaRepository.findAll().getFirst();
        System.out.println("Categoria Encontrada: " + categoria.getNome() + " " + categoria.getId());

        System.out.println("=== PRODUTO REPOSITORY ===");

        System.out.println("findByNome:");
        produtoRepository.findByNome("Uva")
                .forEach(p -> System.out.println(p.getNome()));

        System.out.println("findByCategoria:");
        produtoRepository.findByCategoria(categoria)
                .forEach(p -> System.out.println(p.getNome()));

        System.out.println("findByPrecoGreaterThan:");
        produtoRepository.findByPrecoGreaterThan(10.0)
                .forEach(p -> System.out.println(p.getNome()));

        System.out.println("findByPrecoLessThan:");
        produtoRepository.findByPrecoLessThan(11.3)
                .forEach(p -> System.out.println(p.getNome()));

        System.out.println("findByNomeContainingIgnoreCase:");
        produtoRepository.findByNomeContainingIgnoreCase("ma")
                .forEach(p -> System.out.println(p.getNome()));

        System.out.println("findByCategoriaOrderByPreco:");
        produtoRepository.findByCategoriaOrderByPreco(categoria)
                .forEach(p -> System.out.println(p.getNome() + " - " + p.getPreco()));

        System.out.println("findByCategoriaOrderByPrecoDesc:");
        produtoRepository.findByCategoriaOrderByPrecoDesc(categoria)
                .forEach(p -> System.out.println(p.getNome() + " - " + p.getPreco()));

        System.out.println("findTop3ByOrderByPrecoDesc:");
        produtoRepository.findTop3ByOrderByPrecoDesc()
                .forEach(p -> System.out.println(p.getNome() + " - " + p.getPreco()));

        System.out.println("findTop5ByCategoriaOrderByPreco:");
        produtoRepository.findTop5ByCategoriaOrderByPreco(categoria)
                .forEach(p -> System.out.println(p.getNome() + " - " + p.getPreco()));

        System.out.println("countByCategoria:");
        System.out.println(produtoRepository.countByCategoria(categoria));

        System.out.println("countByPrecoGreaterThan:");
        System.out.println(produtoRepository.countByPrecoGreaterThan(5.0));

        System.out.println("countByPrecoLessThanOrNomeContainingIgnoreCase:");
        System.out.println(produtoRepository.countByPrecoLessThanOrNomeContainingIgnoreCase(15.0, "ma"));

        System.out.println("\n=== PEDIDO REPOSITORY ===");

        System.out.println("findByDataNull:");
        pedidoRepository.findByDataNull()
                .forEach(p -> System.out.println(p.getId()));

        System.out.println("findByDataNotNull:");
        pedidoRepository.findByDataNotNull()
                .forEach(p -> System.out.println(p.getId() + " - " + p.getData()));

        System.out.println("findByDataGreaterThan:");
        pedidoRepository.findByDataGreaterThan(LocalDate.now().minusDays(1))
                .forEach(p -> System.out.println(p.getId()));

        System.out.println("findByDataLessThan:");
        pedidoRepository.findByDataLessThan(LocalDate.now().plusDays(1))
                .forEach(p -> System.out.println(p.getId()));

        System.out.println("findByDataBetween:");
        pedidoRepository.findByDataBetween(
                LocalDate.now().minusDays(5),
                LocalDate.now().plusDays(5)
        ).forEach(p -> System.out.println(p.getId()));
    }
}
