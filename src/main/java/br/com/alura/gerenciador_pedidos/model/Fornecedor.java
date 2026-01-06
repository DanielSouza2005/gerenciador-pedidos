package br.com.alura.gerenciador_pedidos.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "fornecedor")
@Entity
@SequenceGenerator(
        name = "fornecedor_seq",
        sequenceName = "fornecedor_seq",
        allocationSize = 1
)
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fornecedor_seq")
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FornecedorProduto> produtos = new ArrayList<>();

    public Fornecedor() {
    }

    public Fornecedor(String nome) {
        this.nome = nome;
    }

    public Fornecedor(String nome, List<FornecedorProduto> produtos) {
        this.nome = nome;
        this.produtos = produtos;
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

    public List<FornecedorProduto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<FornecedorProduto> produtos) {
        this.produtos = produtos;
    }
}
