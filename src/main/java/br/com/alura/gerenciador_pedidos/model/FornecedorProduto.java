package br.com.alura.gerenciador_pedidos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fornecedor_produto")
@SequenceGenerator(
        name = "fornecedor_produto_seq",
        sequenceName = "fornecedor_produto_seq",
        allocationSize = 1
)
public class FornecedorProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fornecedor_produto_seq")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    public FornecedorProduto() {
    }

    public FornecedorProduto(Produto produto, Fornecedor fornecedor) {
        this.produto = produto;
        this.fornecedor = fornecedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
