package com.example.front_e_back.Controller;

import com.example.front_e_back.DTO.ProdutoDTO;

import com.example.front_e_back.Entity.Produto;
import com.example.front_e_back.Services.ProdutoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ProdutoController {
    @Autowired
    private ProdutoServices produtoServices;

    @PostMapping
    public ResponseEntity<ProdutoDTO>create(@RequestBody ProdutoDTO produtoDTO){
    ProdutoDTO produto = produtoServices.save(produtoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }
    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoServices.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getById(@PathVariable Long id) {
        Optional<ProdutoDTO> professorDTO = produtoServices.getById(id);
        if (professorDTO.isPresent()) {
            return ResponseEntity.ok(professorDTO.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
