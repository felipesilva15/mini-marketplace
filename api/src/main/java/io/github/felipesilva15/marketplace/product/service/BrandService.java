package io.github.felipesilva15.marketplace.product.service;

import io.github.felipesilva15.marketplace.product.model.Brand;
import io.github.felipesilva15.marketplace.product.repository.BrandRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Transactional(readOnly = true)
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Brand findById(Long id) {
        return brandRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Record not found."));
    }

    @Transactional
    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }

    @Transactional
    public Brand update(Long id, Brand brand) {
        Brand existingBrand = findById(id);

        brand.setId(existingBrand.getId());
        brand.setCreatedAt(existingBrand.getCreatedAt());

        return brandRepository.save(brand);
    }

    @Transactional
    public void delete(Long id) {
        Brand existingBrand = findById(id);
        brandRepository.deleteById(existingBrand.getId());
    }
}
