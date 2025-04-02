package com.example.front_e_back.DTO;

public class ProdutoDTO {
    private String nome;
    private float preco;

    public ProdutoDTO produtoDTO(){
    }
    public ProdutoDTO(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
