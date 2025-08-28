package io.github.felipesilva15.marketplace.stock.service;

import io.github.felipesilva15.marketplace.product.model.Product;
import io.github.felipesilva15.marketplace.product.repository.ProductRepository;
import io.github.felipesilva15.marketplace.stock.dto.MovementDTO;
import io.github.felipesilva15.marketplace.stock.mapper.MovementMapper;
import io.github.felipesilva15.marketplace.stock.model.Movement;
import io.github.felipesilva15.marketplace.stock.repository.MovementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MovementService {
    private final MovementRepository movementRepository;
    private final ProductRepository productRepository;
    private final MovementMapper movementMapper;

    public MovementService(MovementRepository movementRepository, ProductRepository productRepository, MovementMapper movementMapper) {
        this.movementRepository = movementRepository;
        this.productRepository = productRepository;
        this.movementMapper = movementMapper;
    }

    @Transactional(readOnly = true)
    public List<MovementDTO> findAll() {
        List<Movement> movements = movementRepository.findAll();

        List<Long> productIds = movements
                .stream()
                .map(Movement::getProductId)
                .toList();

        List<Product> products = productRepository.findAllById(productIds);

        Map<Long, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getId, Function.identity()));

        return movements
                .stream()
                .map(movement -> {
                    MovementDTO movementDTO = movementMapper.toDTO(movement);
                    movementDTO.setProduct(productMap.get(movement.getProductId()));

                    return movementDTO;
                })
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MovementDTO findById(Long id) {
        Movement movement = movementRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Record not found."));

        Optional<Product> product = productRepository
                .findById(movement.getProductId());

        MovementDTO movementDTO = movementMapper.toDTO(movement);
        movementDTO.setProduct(product.orElse(null));

        return movementDTO;
    }

    @Transactional
    public MovementDTO create(Movement movement) {
        Movement newMovement = movementRepository.save(movement);

        return findById(newMovement.getId());
    }

    @Transactional
    public MovementDTO update(Long id, Movement movement) {
        MovementDTO existingMovement = findById(id);

        movement.setId(existingMovement.getId());
        movement.setCreatedAt(existingMovement.getCreatedAt());

        movementRepository.save(movement);

        return findById(id);
    }

    @Transactional
    public void delete(Long id) {
        MovementDTO existingMovement = findById(id);
        movementRepository.deleteById(existingMovement.getId());
    }
}
