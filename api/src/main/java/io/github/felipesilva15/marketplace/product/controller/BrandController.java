package io.github.felipesilva15.marketplace.product.controller;

import io.github.felipesilva15.marketplace.product.dto.BrandRequest;
import io.github.felipesilva15.marketplace.product.dto.BrandResponse;
import io.github.felipesilva15.marketplace.product.mapper.BrandMapper;
import io.github.felipesilva15.marketplace.product.model.Brand;
import io.github.felipesilva15.marketplace.product.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    private final BrandService brandService;
    private final BrandMapper brandMapper;
    
    public BrandController(BrandService brandService, BrandMapper brandMapper) {
        this.brandService = brandService;
        this.brandMapper = brandMapper;
    }

    @GetMapping
    public ResponseEntity<List<BrandResponse>> findAll(){
        List<Brand> brands = brandService.findAll();
        List<BrandResponse> response = brandMapper.toResponseList(brands);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> findById(@PathVariable Long id){
        Brand brand = brandService.findById(id);
        BrandResponse response = brandMapper.toResponse(brand);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<BrandResponse> save(@Valid @RequestBody BrandRequest request){
        Brand brand = brandService.create(brandMapper.toModel(request));
        BrandResponse response = brandMapper.toResponse(brand);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandResponse> update(@PathVariable Long id, @Valid @RequestBody BrandRequest request){
        Brand brand = brandService.update(id, brandMapper.toModel(request));
        BrandResponse response = brandMapper.toResponse(brand);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BrandResponse> delete(@PathVariable Long id){
        brandService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
