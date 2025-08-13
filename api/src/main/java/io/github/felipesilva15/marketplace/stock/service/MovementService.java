package io.github.felipesilva15.marketplace.stock.service;

import io.github.felipesilva15.marketplace.stock.model.Movement;
import io.github.felipesilva15.marketplace.stock.repository.MovementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovementService {
    private final MovementRepository movementRepository;

    public MovementService(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @Transactional(readOnly = true)
    public List<Movement> findAll() {
        return movementRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Movement findById(Long id) {
        return movementRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Record not found."));
    }

    @Transactional
    public Movement create(Movement movement) {
        return movementRepository.save(movement);
    }

    @Transactional
    public Movement update(Long id, Movement brand) {
        Movement existingMovement = findById(id);

        brand.setId(existingMovement.getId());
        brand.setCreatedAt(existingMovement.getCreatedAt());

        return movementRepository.save(brand);
    }

    @Transactional
    public void delete(Long id) {
        Movement existingMovement = findById(id);
        movementRepository.deleteById(existingMovement.getId());
    }
}
