package com.beira.mar2.controllers;

import com.beira.mar2.dto.ProdutoDTO;
import com.beira.mar2.models.ProdutoModel;
import com.beira.mar2.repositories.ProdutoRepository;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository productRepository;

    @PostMapping
    public ResponseEntity<ProdutoModel> saveProduct(@RequestBody @Valid ProdutoDTO produtoDto) {
        var productModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") int id) {
        Optional<ProdutoModel> productO = productRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productO.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") int id,
                                                @RequestBody @Valid ProdutoDTO productRecordDto) {
        Optional<ProdutoModel> productO = productRepository.findAllById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        var productModel = productO.get();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") int id) {
        Optional<ProdutoModel> productO = productRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        productRepository.delete(productO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto excluído com sucesso!");
    }
}