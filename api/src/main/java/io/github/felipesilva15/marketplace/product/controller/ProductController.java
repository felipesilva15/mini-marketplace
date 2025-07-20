package io.github.felipesilva15.marketplace.product.controller;

import io.github.felipesilva15.marketplace.product.dto.ProductRequest;
import io.github.felipesilva15.marketplace.product.dto.ProductResponse;
import io.github.felipesilva15.marketplace.product.mapper.ProductMapper;
import io.github.felipesilva15.marketplace.product.model.Product;
import io.github.felipesilva15.marketplace.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;
    
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(){
        List<Product> products = productService.findAll();
        List<ProductResponse> response = productMapper.toResponseList(products);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id){
        Product product = productService.findById(id);
        ProductResponse response = productMapper.toResponse(product);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request){
        Product product = productService.create(productMapper.toModel(request));
        ProductResponse response = productMapper.toResponse(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @Valid @RequestBody ProductRequest request){
        Product product = productService.update(id, productMapper.toModel(request));
        ProductResponse response = productMapper.toResponse(product);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponse> delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
