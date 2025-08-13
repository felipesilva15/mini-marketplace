package io.github.felipesilva15.marketplace.product.repository;

import io.github.felipesilva15.marketplace.product.model.Brand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class BrandRepositoryTest {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("Should save and retrieve brand")
    void shouldSaveAndRetrieveBrand() {
        Brand newBrand = new Brand(
                null,
                "Brand test"
        );

        Brand savedBrand = brandRepository.save(newBrand);

        assertNotNull(savedBrand.getId());

        Optional<Brand> retrievedBrand = brandRepository.findById(savedBrand.getId());

        assertTrue(retrievedBrand.isPresent());
        assertEquals(savedBrand.getId(), retrievedBrand.get().getId());
        assertEquals("Brand test", retrievedBrand.get().getName());
    }

    @Test
    @DisplayName("Should delete brand")
    void shouldDeleteBrand() {
        Brand brandToDelete = new Brand(
                null,
                "Brand test"
        );
        entityManager.persistAndFlush(brandToDelete);
        Long brandId = brandToDelete.getId();

        brandRepository.deleteById(brandId);

        Optional<Brand> foundBrand = brandRepository.findById(brandId);
        assertFalse(foundBrand.isPresent());
    }
}
