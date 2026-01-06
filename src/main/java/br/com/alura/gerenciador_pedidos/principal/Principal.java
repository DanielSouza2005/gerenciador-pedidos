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
}
