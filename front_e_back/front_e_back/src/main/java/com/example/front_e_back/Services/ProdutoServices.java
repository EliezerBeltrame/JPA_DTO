package com.example.front_e_back.Services;

import com.example.front_e_back.DTO.ProdutoDTO;
import com.example.front_e_back.Entity.Produto;
import com.example.front_e_back.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class ProdutoServices {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto fromDTO(ProdutoDTO produtoDTO){
        Produto produto= new ProdutoDTO();
        produto.setNome(produtoDTO.getNome());
        return produto;
    }
    public ProdutoDTO toDTO(Produto produto){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome(produto.getNome());
        return produtoDTO;
    }
    public List<Produto> getAll(){
        return produtoRepository.findAll();
    }

    public Optional<ProdutoDTO> getById(Long id){

        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if(Produto.isPresent()){
            return Optional.of(this.toDTO(Produto.get());
        }else {
            return Optional.empty();
        }
    }

    public ProdutoDTO save(ProdutoDTO produtoDTO){
        ProdutoDTO produto1= this.fromDTO(produtoDTO);
        ProdutoDTO produto1= produtoRepository.save(produto);
        return this.toDTO(produto1);
    }

    public Optional<ProdutoDTO> updateProduto(Long id, ProdutoDTO produtoDTO){
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if(Produto.isPresent()){
            Produto produto= Produto.get();
            Produto produtoUpdate = produtoRepository.save(produto);
            return Optional.of(this.toDTO(produtoUpdate));
        }else {
            return Optional.empty();
        }
    }
    public boolean delete(Long id){
        if(produtoRepository.existsById(id)){
            produtoRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
