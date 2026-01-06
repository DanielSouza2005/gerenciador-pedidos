package br.com.alura.gerenciador_pedidos.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Table(name = "produto")
@Entity
@SequenceGenerator(
        name = "produto_seq",
        sequenceName = "produto_seq",
        allocationSize = 1
)
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(name = "valor")
    private Double preco;

    @ManyToOne
    private Categoria categoria;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FornecedorProduto> fornecedores = new ArrayList<>();

    public Produto() {
    }

    public Produto(String nome, Double preco, Categoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Produto(String nome, Double preco, Categoria categoria, List<FornecedorProduto> fornecedores) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.fornecedores = fornecedores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<FornecedorProduto> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<FornecedorProduto> fornecedores) {
        this.fornecedores = fornecedores;
    }
}
